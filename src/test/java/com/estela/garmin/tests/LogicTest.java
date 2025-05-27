package com.estela.garmin.tests;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Assert;

public class LogicTest {
    
    public int somaDe1AteN(int n) {
        int soma = 0;

        // for(int i = 1; i <= n; i++) {
        //     soma += i;
        // }

        soma = (n * (1 + n)) / 2; //Soma dos termos de uma Progressão Aritmética

        return soma;
    }

    @Test
    public void deveSomarDe1AteN() {
        Assert.assertEquals(5050, somaDe1AteN(100));
        Assert.assertEquals(15, somaDe1AteN(5));
        Assert.assertEquals(1, somaDe1AteN(1));
        Assert.assertEquals(0, somaDe1AteN(0));

    }

    public int somaOsPares(int A[]) {
        int somaDosPares = 0;

        for (int i : A) {
            if (i%2 == 0) {
                somaDosPares += i;
            }
        }

        return somaDosPares;
    }

    @Test
    public void deveSomarPares() {
        Assert.assertEquals(12, somaOsPares(new int[] {1, 2, 3, 4, 5, 6}));
        Assert.assertEquals(0, somaOsPares(new int[] {7, 9, 11}));
        Assert.assertEquals(20, somaOsPares(new int[] {2, 4, 6, 8}));
    }

    public int somaDaMatriz(int M[][]) {
        int somaDaMatriz = 0;

        for (int[] linha : M) {
            for (int valor : linha) {
                somaDaMatriz += valor;
            }
        }

        return somaDaMatriz;
    }

    @Test
    public void deveSomarValoresMatriz() {
        Assert.assertEquals(21, somaDaMatriz(new int[][] {
            {1, 2, 3},
            {4, 5, 6}    
        }));
        Assert.assertEquals(0, somaDaMatriz(new int[][] {
            {0, 0},
            {0, 0}
        }));
        Assert.assertEquals(24, somaDaMatriz(new int[][] {
            {7, 8, 9}
        }));
    }

    //Classificação de temperatura
    public String getTempClass(int t) {
        String tempClass = null;

        if (t < 0) {
            tempClass = "Congelando";
        } else if (0 <= t && t < 15) {
            tempClass = "Frio";
        } else if (15 <= t && t < 25) {
            tempClass = "Agradável";
        } else if (25 <= t && t < 35) {
            tempClass = "Quente";
        } else {
            tempClass = "Muito Quente";
        }

        return tempClass;
    }

    @Test
    public void deveRetornarClassificacaoCorreta() {
        Assert.assertEquals("Congelando", getTempClass(-5));
        Assert.assertEquals("Frio", getTempClass(8));
        Assert.assertEquals("Agradável", getTempClass(20));
        Assert.assertEquals("Quente", getTempClass(30));
        Assert.assertEquals("Muito Quente", getTempClass(37));
    }

    // Detecção de picos
    public int detectaPicos(int P[]) {
        int picos = 0;
        int aChecar = P.length -1;

        for(int i = 1; i <= aChecar; i++){
            if(P[i-1] < P[i] && P[i] > P[i+1]) {
                picos++;
            }
        }
        System.out.println("P=" + Arrays.toString(P) + ", picos encontrados: " + picos);
        return picos;
    }

    @Test
    public void deveRetornarQuantidadeDePicos() {
        Assert.assertEquals(3, detectaPicos(new int[] {30, 32, 31, 33, 29, 35, 28}));
        Assert.assertEquals(0, detectaPicos(new int[] {25, 24, 23}));
        Assert.assertEquals(1, detectaPicos(new int[] {20, 30, 20}));
    }

    public int contaSubidas(int T[]) {
        int subidas = 0;
        int check = T.length;
        boolean quebra = true;

        for(int i = 1; i < check; i++) {
            if(T[i] > T[i-1]) {
                if(quebra == true) {
                    subidas++;
                    quebra = false;
                }
            } else {
                quebra = true;
            }
        }
        System.out.println("T=" + Arrays.toString(T) + ", subidas encontrados: " + subidas);
        return subidas;
    }

    @Test
    public void deveRetornarSubidas() {
        Assert.assertEquals(3, contaSubidas(new int[] {10, 12, 14, 13, 15, 14, 16, 18, 17}));
        Assert.assertEquals(0, contaSubidas(new int[] {25, 24, 23, 22}));
        Assert.assertEquals(1, contaSubidas(new int[] {30, 32, 34, 36, 38}));
    }
}
