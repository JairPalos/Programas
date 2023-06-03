;*****************************************
;*****************************
;                                                                     *
;    Filename:	    xxx.asm                                           *
;    Date:                                                            *
;    File Version:                                                    *
;                                                                     *
;    Author:                                                          *
;    Company:                                                         *
;                                                                     *
;                                                                     *
;**********************************************************************
;                                                                     *
;    Files Required: P16F887.INC                                      *
;                                                                     *
;**********************************************************************
;                                                                     *
;    Notes:                                                           *
;                                                                     *
;**********************************************************************


	list		p=16f887	; list directive to define processor
	#include	<p16f887.inc>	; processor specific variable definitions


	__CONFIG    _CONFIG1, _LVP_OFF & _FCMEN_ON & _IESO_OFF & _BOR_OFF & _CPD_OFF & _CP_OFF & _MCLRE_ON & _PWRTE_ON & _WDT_OFF & _INTRC_OSC_NOCLKOUT
	__CONFIG    _CONFIG2, _WRT_OFF & _BOR21V

;***** VARIABLE DEFINITIONS
	CBLOCK 	0X20
			Q,M,N,var_1,CONTADOR,CONTADOR2
	ENDC

;**********************************************************************
ORG     0x000             ; processor reset vector

	nop
  	goto    PORTS_CONFING              ; go to beginning of program
;******Configuracion de Puertos

PORTS_CONFING
	BSF 	STATUS,RP0		;*** Se pone el status en uno
	MOVLW 	0XFF			; Se pone los puertos de entrada
	MOVWF 	TRISA			;***** Se para al puerto a 
	MOVLW 	0X00			;**** se inicializa en ceros
	MOVWF 	TRISB			;***  Se le pasa al puerto b
	BSF		STATUS,RP1		;*** se pone  status en uno
	CLRF 	ANSEL			;*** Se limpia el ansel
	CLRF 	ANSELH			;*** Se limpia el anselh
	BCF 	STATUS,RP0		;	Se pone en ceros
	BCF		STATUS,RP1		; Se pone en ceros
	CLRF 	PORTA			; Se limpia el puerto a
	CLRF 	PORTB			; Se limpia el puerto b
 	

PRINCIPAL; Se crea la etiqueta principal
	 	
		BCF		STATUS,C		;limpia el acarreo
		CLRF	CONTADOR		;limpia el acuulado
		BCF		STATUS,C		;limpia el acarreo
		MOVF	CONTADOR,W		;pasa el valor de acarreo al acumulador
		CALL	TABLA_1			;llama a tabla
		MOVWF	PORTB			;lo mueve al puerto b
		CALL 	RETARDO			; se Crea la etiqueta retardo
		BTFSS	PORTA,0
		GOTO	CONTAR1			;llama a la tabla 1
		GOTO	CONTAR0	
	

CONTAR0	
		
		INCF	CONTADOR,1		;incrementa el valor en 1
		MOVLW	D'16'			;pasa el valor al acarreo
		BTFSC	PORTA,0
		GOTO	CONTAR1		;llama a la tabla 1
		SUBWF	CONTADOR,W		;resta  lo que esta el e
		BTFSC	STATUS,C		; si hay  accareo
		GOTO	PRINCIPAL		;regresa al principal
		MOVF	CONTADOR,0		; mueve el valor del contador al acarreo
		CALL	TABLA_1			;llama a tabla
		MOVWF	PORTB			;lo mueve al puerto b
		CALL 	RETARDO			;llama a retardo
		GOTO	CONTAR0			;regresa a contar
		
CONTAR1
		
		
		
	
TABLA_1
		ADDWF	PCL,F		; añade lo que esta en el contador interno
		RETLW	b'1000000'	;0
		RETLW	b'1111001'	;1
		RETLW	b'0100100'	;2
		RETLW	b'0110000'	;3
		RETLW	b'0011001'	;4
		RETLW	b'0010010'	;5
		RETLW	b'0000010'	;6
		RETLW	b'1111000'	;7
		RETLW	b'0000000'	;8
		RETLW	b'0010000'	;9
		RETLW	b'0001000'	;A
		RETLW	b'0000011'	;B
		RETLW	b'1000110'	;C
		RETLW	b'0100001'	;D
		RETLW	b'0000110'	;E
		RETLW	b'0001110'	;F	

;******************RETARDO**********************************************************************	
RETARDO
	MOVLW 	D'5'
 	MOVWF  	Q
	TRES
	MOVLW	D'100'
	MOVWF	M
	DOS
	MOVLW	D'100'
	MOVWF	N
	UNO
	NOP
	NOP
	DECFSZ	N,1
	GOTO	UNO
	DECFSZ	M,1
	GOTO	DOS
	DECFSZ	Q,1
	GOTO	TRES
	RETURN

END                       ; directive 'end of program'