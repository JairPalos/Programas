;**********************************************************************
;                                                                     *
;    Filename:	    xxx.asm                                           *
;    Date:                                                            *
;    File Version:                                                    *
;                                                                     *
;    Author:                                                        *
;    Company:                                                         *
;                                                                     *
;                                                                     *
;**********************************************************************
;    Notes:                                                           *
;                                                                     *
;**********************************************************************


	list		p=16f887	; list directive to define processor
	#include	<p16f887.inc>	; processor specific variable definitions

	__CONFIG    _CONFIG1, _LVP_OFF & _FCMEN_ON & _IESO_OFF & _BOR_OFF & _CPD_OFF & _CP_OFF & _MCLRE_ON & _PWRTE_ON & _WDT_OFF & _INTRC_OSC_NOCLKOUT
	__CONFIG    _CONFIG2, _WRT_OFF & _BOR21V




;***** VARIABLE DEFINITIONS
CBLOCK		0X20
		CONTADOR, CTR1, CTR2, CTR3
ENDC
;**********************************************************************
	ORG     	0x000			; processor reset vector

	nop
  	goto    	PORTS_CONFIG	; go to beginning of program

PORTS_CONFIG
	BSF			STATUS,RP0		;Cambiamos al banco 1
	MOVLW		0XFF			
	MOVWF		TRISA			;Configuramos a PORTA como entrada
	
	MOVLW		0X00			
	MOVWF		TRISB			;Configura el PORTB como salida
	
	BSF			STATUS, RP1		;Cambiamos al banco 3	
	CLRF		ANSEL			;Configura al PORTA como digital
	CLRF		ANSELH			;Configura al PORTB como digital
	BCF			STATUS, RP0		;Cambiamos al banco 0
	BCF			STATUS, RP1	

	CLRF		PORTA			;Limpiando portales
	CLRF		PORTB	
;*******************************************************************************************
		
PRINCIPAL

	MOVF		PORTA,W				;Pasa el valor del purto A a W
	ANDLW		B'00001111'			;Agrega 16 bits a W
	CALL		TABLA_1				;Busca el valor de w en tabla y lo refresa en W
	MOVWF		PORTB				;El resultado se muestra en el puerto B
	GOTO		PRINCIPAL			

;***************************************************************************************
	
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

END                       ; directive 'end of program'