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
	BSF 	STATUS,RP0			;*** Se pone el status en uno
	MOVLW 	0XFF				; Se pone los puertos de entrada
	MOVWF 	TRISA				;***** Se para al puerto a 
	MOVLW 	0X00				;**** se inicializa en ceros
	MOVWF 	TRISB				;***  Se le pasa al puerto b
	BSF		STATUS,RP1			;*** se pone  status en uno
	CLRF 	ANSEL				;*** Se limpia el ansel
	CLRF 	ANSELH				;*** Se limpia el anselh
	BCF 	STATUS,RP0			;	Se pone en ceros
	BCF		STATUS,RP1			; Se pone en ceros
	CLRF 	PORTA				; Se limpia el puerto aHGG
	CLRF 	PORTB				; Se limpia el puerto b
 	
PRINCIPAL						; Se crea la etiqueta principal
		
		BCF 	STATUS,C		;**** Se limpia el acarreo
		MOVF  	PORTA,1 		;**** Mueve el valor al puerto a
		BTFSS	PORTA,1			;**** En el puerto en el indice 0 es 1
		GOTO	PRIMERAS		;**** Se va a izquierda 2
		GOTO	SEGUNDAS		;**** Se va a Izquierda 1
		

PRIMERAS						;*** Se crea la etiqueta primeras
		BTFSC	PORTA,0			;***si el puerto a en bit 0
		GOTO	IZQUIERDA1		;*** Si es cero se va a la Etiqueta Rotarizquierda2
		GOTO	IZQUIERDA0		;*** Si es uno se va a la etiqueta rotarizquierda

SEGUNDAS						;*** Se crea la etiqueta primeras
		BTFSC	PORTA,0			;***si el puerto a en bit 0
		GOTO	DERECHA1		;*** Si es cero se va a la Etiqueta Rotarizquierda2
		GOTO	DERECHA0		;*** Si es uno se va a la etiqueta rotarizquierda

IZQUIERDA1						;**** Se cre a la etiqueta 
		
		BTFSC	PORTA,1			;**** En el puerto en el indice 1 es 1
		GOTO	SEGUNDAS
		BTFSS	PORTA,0			;**** En el puerto en el indice 0 es 0
		GOTO	IZQUIERDA0		;**** Se va a Izquierda 1
		MOVLW   b'00000001'		;**** Se agrea el valor uno al acarreo
		MOVWF   PORTB			;**** Mueve el valor al puerto b
		BTFSS	PORTA,0			;**** En el puerto en el indice 0 es 1
		GOTO	PRIMERAS		;**** Se va a Izquierda 2
		GOTO	IZQUIERDA1		;**** Sr¿e va a izquierda 1

IZQUIERDA0						;**** Se cre a la etiqueta 

		BTFSC	PORTA,1			;**** En el puerto en el indice 1 es 1
		GOTO	SEGUNDAS	
		BTFSC	PORTA,0			;**** En el puerto en el indice 0 es 1
		GOTO	DERECHA1		;**** Se va a Izquierda 1
		MOVLW   b'00000010'		;**** Se agrea el valor uno al acarreo
		MOVWF   PORTB			;**** Mueve el valor al puerto b
		BTFSC	PORTA,0			;**** En el puerto en el indice 0 es 1
		GOTO	PRINCIPAL		;**** Se va a Izquierda 2
		GOTO	IZQUIERDA0		;**** Sr¿e va a izquierda 1


DERECHA1						;**** Se cre a la etiqueta 
		
		BTFSS	PORTA,1			;**** En el puerto en el indice 1 es 1
		GOTO	PRIMERAS
		BTFSC	PORTA,0			;**** En el puerto en el indice 0 es 0
		GOTO	DERECHA0		;**** Se va a Izquierda 1
		MOVLW   b'00000100'		;**** Se agrea el valor uno al acarreo
		MOVWF   PORTB			;**** Mueve el valor al puerto b
		BTFSS	PORTA,1			;**** En el puerto en el indice 0 es 1
		GOTO	PRINCIPAL		;**** Se va a Izquierda 2
		GOTO	DERECHA1		;**** Sr¿e va a izquierda 1

DERECHA0						;**** Se cre a la etiqueta 

		BTFSS	PORTA,1			;**** En el puerto en el indice 1 es 1
		GOTO	PRIMERAS	
		BTFSS	PORTA,0			;**** En el puerto en el indice 0 es 1
		GOTO	DERECHA1		;**** Se va a Izquierda 1
		MOVLW   b'00001000'		;**** Se agrea el valor uno al acarreo
		MOVWF   PORTB			;**** Mueve el valor al puerto b
		BTFSS	PORTA,1			;**** En el puerto en el indice 0 es 1
		GOTO	PRINCIPAL		;**** Se va a Izquierda 2
		GOTO	DERECHA0		;**** Sr¿e va a izquierda 1


END                      		 ; directive 'end of program'

