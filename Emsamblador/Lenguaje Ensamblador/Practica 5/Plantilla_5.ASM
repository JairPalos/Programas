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
			Q,M,N,var_1
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
	CLRF 	PORTA			; Se limpia el puerto aHGG
	CLRF 	PORTB			; Se limpia el puerto b
 	
PRINCIPAL; Se crea la etiqueta principal
		
		BCF 	STATUS,C		;****Se limpia el acarreo
		MOVF  	PORTA,1			;**** Mueve el valor al puerto a
		MOVLW 	B'00000001' 	;*****Se pone un 1 en binario en el acarre0
		MOVWF	PORTB			;****** Se pasa el valor de uno del acarreo al puerto b
		BTFSS	PORTA,1			;*** Si el valor en el bit 1
		GOTO 	PRIMERAS		;*** Si es cero se pasa a la etiqueta Primeras
		GOTO	SEGUNDAS		;*** Si es uno se pasa a la etiqueta Segundas

;*********************PARA LLEGAR LA SECUENCIA 0 Y 1

PRIMERAS;*** Se crea la etiqueta primeras
		BTFSS	PORTA,0			;***si el puerto a en bit 0
		GOTO	ROTARIZQUIERDA2	;*** Si es cero se va a la Etiqueta Rotarizquierda2
		GOTO	ROTARIZQUIERDA	;*** Si es uno se va a la etiqueta rotarizquierda

;*********************PARA LLEGAR A  SEGUN 2 Y 3 

SEGUNDAS;*** Se crea la etiqueta segundas
		BTFSS	PORTA,0			;***Si el puerto a en bit 0
		GOTO	ROTARDERECHA2	;***  Si es cero se va a la etiqueta rotarderecha2
		GOTO	NUEVASECUENCIA	;*** Si es uno se va a la etiqueta nuevasecuencia
		
;************************0,0***************************************************************

ROTARIZQUIERDA2;*** Se crea la etiqueta ROTARIZQUIERDA2
		BTFSC	PORTA,1			;*** Si puerto a es en el bit 1
		GOTO	SEGUNDAS		;*** Si es uno se va a la etiquta segundas
		BTFSC	PORTA,0			;*** Si puerto a es en el bit 0 
		GOTO 	ROTARDERECHA	;*** Si es uno se va a la etiqueta ROTARDERECHA
		RLF 	PORTB,1			;** Se recorre hacia la izquierda poniendo un uno
		CALL	RETARDO			;** Se llama la etiqueta retardo
		BTFSS	PORTB,0			;**** Si el valor del puerto b esta en el 7 hace lo sieguitente
		GOTO	ROTARIZQUIERDA2	;**** si es un cero regresa a la etiqueta izquierda
		GOTO	PRINCIPAL		;* si es un uno se va a la etiqueta derecha


;********************0,1**********************************************************

ROTARIZQUIERDA;*** Se crea la etiqueta ROTARIZQUIERDA
		BTFSC	PORTA,1			;*** Si puerto a es en el bit 1
		GOTO	SEGUNDAS		;*** Se va a la etiqueta segundas
		BTFSS	PORTA,0			;*** Si puerto a es en el bit 0 
		GOTO 	ROTARIZQUIERDA2	;*** Se va a la etiqueta rotarizquieda
		RLF 	PORTB,1			;** Se recorre hacia la izquierda poniendo un uno
		CALL	RETARDO			;** Se llama la etiqueta retardo
		BTFSS	PORTB,7			;**** Si el valor del puerto b esta en el 7 hace lo sieguitente
		GOTO	ROTARIZQUIERDA	;**** si es un cero regresa a la etiqueta izquierda
		GOTO	ROTARDERECHA	;****** si es un uno se va a la etiqueta derecha

ROTARDERECHA
		BTFSC	PORTA,1			;*** Si puerto a es en el bit 1
		GOTO	SEGUNDAS		;*** Se va a la etiqueta segundas
		BTFSS	PORTA,0			;*** Si puerto a es en el bit 0 
		GOTO 	ROTARIZQUIERDA2	;*** Se va a la etiqueta rotarizquieda
		RRF		PORTB,1			;** Se recorre hacia la derecha poniendo un uno
		CALL	RETARDO			;** Se llama la etiqueta retardo
		BTFSS	PORTB,0			;**** Si el valor del puerto b esta en el 7 hace lo sieguitente
		GOTO	ROTARDERECHA	;**** si es un cero regresa a la etiqueta derecha
		GOTO	PRINCIPAL		;* si es un cero se va a la etiqueta pricipal

;*********************1,0**********************************************************************
ROTARDERECHA2;*** Se crea la etiqueta ROTARDERECHA2	

		BTFSS	PORTA,1			;*** Si puerto a es en el bit 1 
		GOTO	PRIMERAS		;*** Se va a la etiqueta primeras
		BTFSC	PORTA,0			;*** Si puerto a es en el bit 0 
		GOTO 	NUEVASECUENCIA	;*** Se va a la etiqueta nuevasecuencia
		RRF 	PORTB,1			;** Se recorre hacia la derecha poniendo un uno
		CALL	RETARDO			;** Se llama la etiqueta retardo
		BTFSS	PORTB,0			;**** Si el valor del puerto b esta en el 0 hace lo sieguitente
		GOTO	ROTARDERECHA2	;**** si es un cero regresa a la etiqueta izquierda
		GOTO	PRINCIPAL		;* si es un uno se va a la etiqueta derecha

;**********************1,1*************************************************************************	

NUEVASECUENCIA;*** Se crea la etiqueta NUEVASECUENCIA
		CALL	COMPARACION		;*** Llama a la etiqueta comparacion
		MOVLW   b'10000001'		;** se pone el numero binario al acumulador
		MOVWF	PORTB			;****** Se pasa el valor de uno del acarreo al puerto b
		CALL	RETARDO			;** Se llama la etiqueta retardo
		CALL	COMPARACION		;*** Llama a la etiqueta comparacion
		MOVLW   b'01000010'		;** se pone el numero binario al acumulador
		MOVWF	PORTB			;****** Se pasa el valor de uno del acarreo al puerto b
		CALL	RETARDO			;** Se llama la etiqueta retardo
		CALL	COMPARACION		;*** Llama a la etiqueta comparacion
		MOVLW   b'00100100'		;** se pone el numero binario al acumulador
		MOVWF	PORTB			;****** Se pasa el valor de uno del acarreo al puerto b
		CALL	RETARDO			;** Se llama la etiqueta retardo
		CALL	COMPARACION		;*** Llama a la etiqueta comparacion
		MOVLW   b'00011000'		;** se pone el numero binario al acumulador
		MOVWF	PORTB			;****** Se pasa el valor de uno del acarreo al puerto b
		CALL	RETARDO			;** Se llama la etiqueta retardo
		CALL	COMPARACION		;*** Llama a la etiqueta comparacion
		MOVLW   b'00100100'		;** se pone el numero binario al acumulador
		MOVWF	PORTB			;****** Se pasa el valor de uno del acarreo al puerto b
		CALL	RETARDO			;** Se llama la etiqueta retardo
		CALL	COMPARACION		;*** Llama a la etiqueta comparacion
		MOVLW   b'01000010'		;** se pone el numero binario al acumulador
		MOVWF	PORTB			;****** Se pasa el valor de uno del acarreo al puerto b
		CALL	RETARDO			;** Se llama la etiqueta retardo
		CALL	COMPARACION		;*** Llama a la etiqueta comparacion
		GOTO	NUEVASECUENCIA	;*** Regresa a nuevaetiqueta

COMPARACION;*** Se crea la etiqueta comparacion
		
		BTFSS	PORTA,1;*** Si el puerto a en el bit 1
		GOTO	PRINCIPAL;*** Si es cero regresa a la etiqueta principal
		BTFSS	PORTA,0;*** Si el puerto a en el bit 0
		GOTO 	PRINCIPAL;*** Si es cero regresa a la etiqueta principal
		
;******************RETARDO**********************************************************************	
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

