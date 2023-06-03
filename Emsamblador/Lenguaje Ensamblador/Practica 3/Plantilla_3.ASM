;**********************************************************************
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
			Q,M,N
	ENDC

;**********************************************************************
ORG     0x000             ; processor reset vector

	nop
  	goto    PORTS_CONFING              ; go to beginning of program
;******Configuracion de Puertos

PORTS_CONFING
	BSF 	STATUS,RP0
	MOVLW 	0X00
	MOVWF 	TRISB
	BSF		STATUS,RP1
	CLRF 	ANSEL
	CLRF 	ANSELH
	BCF 	STATUS,RP0
	BCF		STATUS,RP1
	CLRF 	PORTB
 	
PRINCIPAL
		MOVLW 	B'00000001' ;*****Se pone un 1 en binario en el acarre0
		MOVWF	PORTB;****** Se pasa el valor de uno del acarreo al puerto b

ROTARIZQUIERDA
		RLF 	PORTB,1;** Se recorre hacia la izquierda poniendo un uno
		CALL	RETARDO;** Se llama la etiqueta retardo
		BTFSS	PORTB,7;**** Si el valor del puerto b esta en el 7 hace lo sieguitente
		GOTO	ROTARIZQUIERDA;**** si es un cero regresa a la etiqueta izquierda
		GOTO	ROTARDERECHA;* si es un uno se va a la etiqueta derecha

ROTARDERECHA
		
		RRF		PORTB,1;** Se recorre hacia la derecha poniendo un uno
		CALL	RETARDO;** Se llama la etiqueta retardo
		BTFSS	PORTB,0;**** Si el valor del puerto b esta en el 7 hace lo sieguitente
		GOTO	ROTARDERECHA;**** si es un cero regresa a la etiqueta derecha
		GOTO	PRINCIPAL;* si es un cero se va a la etiqueta pricipal

RETARDO
	MOVLW 	D'5'
	MOVWF  	Q
	TRES
	MOVLW	D'80'
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

