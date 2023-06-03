"""
UNIVERSIDAD AUTONOMA DEL ESTADO DE MEXICO

Undad de Aprendizaje:

Autor: Dr.Asdrulbal López Chau

Descripcion: Solución al labpratorio de
Descubre la contraseña

Created: on Mon Feb 28 11:28:44 2022
"""
class Sistema:

	def __init__(dany):

		dany.password ="icoic"

	def hack (dany,contrasena):
		ctr=0
		for letraP,letraC in zip(dany.password,contrasena):
			if letraP ==letraC:
				ctr = ctr + 1
		return ctr

	def login(dany, usuario, contrasena):
		return dany.hack(contrasena)

class MyHack:
	def __init__(self,sistema):
		self.target =sistema
		self.alfabeto="abcdefghijklmnopqrstuvwxyz"
		self.N=5

	def fuerzaBruta(self):
		n = self.N
		alfabeto =self.alfabeto
		target=self.target
		for i1 in alfabeto:
			for i2 in alfabeto:
				for i3 in alfabeto:
					for i4 in alfabeto:
						for i5 in alfabeto:
							intento=i1+i2+i3+i4+i5
							if target.login(" ",intento) == 5:
								print("Haked: ")
								print("password: " +intento)
								return 






