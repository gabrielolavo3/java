package br.com.main;
import br.com.entidades.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws OperacaoQuadraException {
		Scanner scan = new Scanner(System.in);
		Quadra tenis = new QuadraTenis("FX07", (short) 4);
		Quadra futsal = new QuadraFutsal("12aD", (short) 10);
		Quadra tenis2 = new QuadraTenis("g67tr", (short) 2);
		Quadra volei = new QuadraVolei("poo15", (short) 12);
		ArrayList<Quadra> quadrasEsportiva = new ArrayList<Quadra>();
		quadrasEsportiva.add(tenis);
		quadrasEsportiva.add(futsal);
		quadrasEsportiva.add(tenis2);
		quadrasEsportiva.add(volei);

	}

}
