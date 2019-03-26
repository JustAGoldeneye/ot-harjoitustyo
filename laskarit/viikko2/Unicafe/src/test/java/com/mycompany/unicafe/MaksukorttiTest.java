package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoAlussaOikein() {
        assertTrue(kortti.saldo()==1000);
    }
    
    @Test
    public void lataaRahaaKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(1000);
        assertTrue(kortti.saldo()==2000);
    }
    
    @Test
    public void otaRahaaVahentaaSaldoaOikein() {
        kortti.otaRahaa(500);
        assertTrue(kortti.saldo()==500);
    }
    
    @Test
    public void otaRahaaEiVahennaSaldoaJosEiTarpeeksiSaldoa() {
        kortti.otaRahaa(1500);
        assertTrue(kortti.saldo()==1000);
    }
    
    @Test
    public void otaRahaaPalauttaaTrueJosRahatRiittavat() {
        assertTrue(kortti.otaRahaa(500));
    }
    
    @Test
    public void otaRahaaPalauttaaFalseJosRahatEivatRiita() {
        assertFalse(kortti.otaRahaa(1500));
    }
    
    @Test
    public void toStringToimii() {
        kortti.lataaRahaa(50);
        assertEquals("saldo: 10.50", kortti.toString());
    }
}
