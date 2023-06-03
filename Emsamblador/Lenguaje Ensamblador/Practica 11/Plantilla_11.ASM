
;                                                                     *
;    Filename:	    xxx.asm                                           *
;    Date:     26 de Febrero 2021                                                   *
;    File Version:                                                    *
;                                                                     *
;    Author:   Jair Antonio Palos Hernandez                                                      *
;    Company:   Sistemas Digitales                                                      *
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

	CBLOCK	0X20
			CounterA,CounterB,CounterC,ELCONT,ELCONT1,ELCONT2,ELCONT3
	ENDC
	
	__CONFIG    _CONFIG1, _LVP_OFF & _FCMEN_ON & _IESO_OFF & _BOR_OFF & _CPD_OFF & _CP_OFF & _MCLRE_ON & _PWRTE_ON & _WDT_OFF & _INTRC_OSC_NOCLKOUT
	__CONFIG    _CONFIG2, _WRT_OFF & _BOR21V

			
	
	
	
	ORG     0x000             ; processor reset vector
	NOP
  	GOTO    config_port             ; go to beginning of program
	

config_port

	BSF		STATUS,RP0		 ;Cambio al Bank_0

	MOVLW	0xFF			;Configua el PORTA 
	MOVWF	TRISA				
;	MOVWF	TRISC

	MOVLW	0x00			;Configuramos el PORTB como salida 
	MOVWF	TRISB
	MOVWF	TRISC
	MOVWF	TRISD
	BSF		STATUS,RP1
	CLRF	ANSEL			;Configuramos el puerto como digital
	CLRF	ANSELH
	BCF		STATUS,RP0
	BCF		STATUS,RP1		;cambiamos de banco 
	MOVLW	0X00
	MOVWF	PORTA
	CLRF	PORTB
	CLRF	PORTC
	GOTO	INICIO

	CLRF	PORTA				;limpio el PORTA
	CLRF	PORTB				;limpio el PORTC
	CLRF	PORTC				;limpio el PORTC
	CLRF	PORTD				;limpio el PORTD




INICIO
	
	BTFSC	PORTA,0
	GOTO 	CON_2
	GOTO	CON_1
	GOTO	INICIO
	
	
CON_1
	BTFSC	PORTA,1
	GOTO	SEC_2
	GOTO	SEC_0
	

CON_2
	BTFSC	PORTA,1
	GOTO	SEC_3
	GOTO	SEC_1


;SECUENCIAS
SEC_0
	MOVLW	B'0001'			
	MOVWF	PORTD	
	GOTO 	ULTI
SEC_1
	MOVLW	B'0010'			
	MOVWF	PORTD
	GOTO 	ULTI_1

SEC_2
	MOVLW	B'0100'			
	MOVWF	PORTD
	GOTO 	ULTI_2

SEC_3
	MOVLW	B'1000'			
	MOVWF	PORTD
	GOTO 	ULTI_3

;MI_DERECHA
;CONTADOR SE LIMPIA
ULTI
	CLRF	ELCONT
;CONTADOR		
PROCEDI	
	CALL	CHECAR_0
	MOVF	ELCONT,W
	CALL	TABLA_1		
	MOVWF	PORTB
	MOVF	ELCONT,W	
	CALL	TABLA		
	MOVWF	PORTC		
	CALL	RETARDO		
	INCF	ELCONT,F	
	MOVLW	.12			
	XORWF	ELCONT,W	
	BTFSS	STATUS,Z	
	GOTO	PROCEDI	
	GOTO	ULTI		
TABLA_1
	;		  ABCDEFGH	 
	ADDWF	PCL,F
	RETLW	b'00110011';M	
	RETLW	b'00110000';1	
	RETLW	b'00001100';_
	RETLW	b'11111100';D
	RETLW	b'11001111';E
	RETLW	b'11100011';R
	RETLW	b'11001111';E
	RETLW	b'11001111';C
	RETLW	b'00110011';H
	RETLW	b'11110011';A

TABLA
	;		  ABCDEFGH	
	ADDWF	PCL,F	
	RETLW	b'10100000';M	
	RETLW	b'00100000';1
	RETLW	b'00000000';_
	RETLW	b'01000100';D	
	RETLW	b'00010001';E
	RETLW	b'00011000';R
	RETLW	b'00010001';E
	RETLW	b'00000000';C
	RETLW	b'00010001';H
	RETLW	b'00010001';A


LIMPIAR
	CLRF	PORTB
	CLRF	PORTC	
	CLRF	PORTD	
	GOTO	INICIO		

CHECAR_0
	BTFSC	PORTA,0		
	GOTO	LIMPIAR
	BTFSC	PORTA,1		
	GOTO	LIMPIAR
	RETURN	
	


;segunda  M1_IZQUIERDA

ULTI_1
	CLRF	ELCONT1
;CONTADOR		
PROCEDI_1
	CALL	CHECAR_1
	MOVF	ELCONT1,W
	CALL	TABLA_21		
	MOVWF	PORTB
	MOVF	ELCONT1,W	
	CALL	TABLA_22		
	MOVWF	PORTC		
	CALL	RETARDO		
	INCF	ELCONT1,F	
	MOVLW	.12			
	XORWF	ELCONT1,W	
	BTFSS	STATUS,Z	
	GOTO	PROCEDI_1	
	GOTO	ULTI_1		

TABLA_21
	;		  ABCDEFGH 
	ADDWF	PCL,F
	RETLW	b'00110011';M	
	RETLW	b'00110000';1	
	RETLW	b'00001100';_
	RETLW	b'11001100';I
	RETLW	b'11001100';Z
	RETLW	b'11110001';Q
	RETLW	b'00111111';U
	RETLW	b'11001100';I
	RETLW	b'11001111';E
	RETLW	b'11100011';R
	RETLW	b'11111100';D
	RETLW	b'11110011';A

TABLA_22
	;		  ABCDEFGH	
	ADDWF	PCL,F	
	RETLW	b'10100000';M	
	RETLW	b'00100000';1
	RETLW	b'00000000';_
	RETLW	b'01000100';I
	RETLW	b'00100010';Z
	RETLW	b'00000001';Q
	RETLW	b'00000000';U
	RETLW	b'01000100';I	
	RETLW	b'00010001';E
	RETLW	b'00011000';R
	RETLW	b'01000100';D
	RETLW	b'00010001';A

	
LIMPIAR_1
	CLRF	PORTB
	CLRF	PORTC	
	CLRF	PORTD	
	GOTO	INICIO		

CHECAR_1
	BTFSS	PORTA,0			
	GOTO	LIMPIAR_1	
	BTFSC	PORTA,1			
	GOTO	LIMPIAR_1
	RETURN


;M2_DERECHA

ULTI_2
	CLRF	ELCONT2
;CONTADOR		
PROCEDI_2
	CALL	CHECAR_2
	MOVF	ELCONT2,W
	CALL	TABLA_31		
	MOVWF	PORTB
	MOVF	ELCONT2,W	
	CALL	TABLA_32		
	MOVWF	PORTC		
	CALL	RETARDO		
	INCF	ELCONT2,F	
	MOVLW	.10			
	XORWF	ELCONT2,W	
	BTFSS	STATUS,Z	
	GOTO	PROCEDI_2	
	GOTO	ULTI_2		

TABLA_31
	;		  HGFEDCBA 
	ADDWF	PCL,F
	RETLW	b'00110011';M	
	RETLW	b'11101110';2	
	RETLW	b'00001100';_
	RETLW	b'11111100';D
	RETLW	b'11001111';E
	RETLW	b'11100011';R
	RETLW	b'11001111';E
	RETLW	b'11001111';C
	RETLW	b'00110011';H
	RETLW	b'11110011';A

TABLA_32
	;		  UTSRPNMK	
	ADDWF	PCL,F	
	RETLW	b'10100000';M	
	RETLW	b'00010001';2
	RETLW	b'00000000';_
	RETLW	b'01000100';D	
	RETLW	b'00010001';E
	RETLW	b'00011000';R
	RETLW	b'00010001';E
	RETLW	b'00000000';C
	RETLW	b'00010001';H
	RETLW	b'00010001';A
	
LIMPIAR_2
	CLRF	PORTB
	CLRF	PORTC
	CLRF	PORTD		
	GOTO	INICIO		

CHECAR_2
	BTFSC	PORTA,0			
	GOTO	LIMPIAR_2	
	BTFSS	PORTA,1		
	GOTO	LIMPIAR_2
	RETURN	





;M2_IZQUIERDA

ULTI_3
	CLRF	ELCONT3
;CONTADOR		
PROCEDI_3
	CALL	CHECAR_3
	MOVF	ELCONT3,W
	CALL	TABLA_41		
	MOVWF	PORTB
	MOVF	ELCONT3,W	
	CALL	TABLA_42		
	MOVWF	PORTC		
	CALL	RETARDO		
	INCF	ELCONT3,F	
	MOVLW	.12			
	XORWF	ELCONT3,W	
	BTFSS	STATUS,Z	
	GOTO	PROCEDI_3	
	GOTO	ULTI_3		

TABLA_41
	;		  HGFEDCBA 
	ADDWF	PCL,F
	RETLW	b'00110011';M	
	RETLW	b'11101110';2	
	RETLW	b'00001100';_
	RETLW	b'11001100';I
	RETLW	b'11001100';Z
	RETLW	b'11110001';Q
	RETLW	b'00111111';U
	RETLW	b'11001100';I
	RETLW	b'11001111';E
	RETLW	b'11100011';R
	RETLW	b'11111100';D
	RETLW	b'11110011';A

TABLA_42
	;		  UTSRPNMK	
ADDWF	PCL,F	
	RETLW	b'10100000';M	
	RETLW	b'00010001';1
	RETLW	b'00000000';_
	RETLW	b'01000100';I
	RETLW	b'00100010';Z
	RETLW	b'00000001';Q
	RETLW	b'00000000';U
	RETLW	b'01000100';I	
	RETLW	b'00010001';E
	RETLW	b'00011000';R
	RETLW	b'01000100';D
	RETLW	b'00010001';A

	
LIMPIAR_3
	CLRF	PORTB
	CLRF	PORTC
	CLRF	PORTD		
	GOTO	INICIO		

CHECAR_3
	BTFSS	PORTA,0			
	GOTO	LIMPIAR_3	
	BTFSS	PORTA,1			
	GOTO	LIMPIAR_3
	RETURN





RETARDO
	
		movlw	D'3'
		movwf	CounterC
		movlw	D'100'
		movwf	CounterB
		movlw	D'120'
		movwf	CounterA
	loop		decfsz	CounterA,1
		goto	loop
		decfsz	CounterB,1
		goto	loop
		decfsz	CounterC,1
		goto	loop
		retlw	0
	RETURN	

	END 