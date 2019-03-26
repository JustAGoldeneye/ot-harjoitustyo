package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    Kassapaate kassa;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }
    
    //Alkutestit
    
    @Test
    public void kassassaRahaaAlussaOikein() {
        assertTrue(kassa.kassassaRahaa()==100000);
    }
    
    @Test
    public void maukkaitaLounaitaMyytyAlussaOikein() {
        assertTrue(kassa.maukkaitaLounaitaMyyty()==0);
    }
    
    @Test
    public void edullisiaLounaitaMyytyAlussaOikein() {
        assertTrue(kassa.edullisiaLounaitaMyyty()==0);
    }
    
    //Käteisostot
    //Maksu riittävä, rahan käsittely
    
    @Test
    public void kassassaRahaaKasvaaOikeinKunSyoMaukkaastiJaMaksaaKateisella() {
        kassa.syoMaukkaasti(1000);
        kassa.syoMaukkaasti(1000);
        assertTrue(kassa.kassassaRahaa()==100800);
    }
    
    @Test
    public void kassassaRahaaKasvaaOikeinKunSyoEdullisestiJaMaksaaKateisella() {
        kassa.syoEdullisesti(1000);
        kassa.syoEdullisesti(1000);
        assertTrue(kassa.kassassaRahaa()==100480);
    }
    
    @Test
    public void kassassaRahaaKasvaaOikeinKunSyoMaukkaastiJaMaksaaKateisellaTasarahalla() {
        kassa.syoMaukkaasti(400);
        kassa.syoMaukkaasti(400);
        assertTrue(kassa.kassassaRahaa()==100800);
    }
    
    @Test
    public void kassassaRahaaKasvaaOikeinKunSyoEdullisestiJaMaksaaKateisellaTasarahalla() {
        kassa.syoEdullisesti(240);
        kassa.syoEdullisesti(240);
        assertTrue(kassa.kassassaRahaa()==100480);
    }
    
    @Test
    public void vaihtorahanSummaOikeinKunSyoMaukkaastiJaMaksaaKateisella() {
        assertTrue(kassa.syoMaukkaasti(1000)==600);
        
    }
    
    @Test
    public void vaihtorahanSummaOikeinKunSyoEdullisestiJaMaksaaKateisella() {
        assertTrue(kassa.syoEdullisesti(1000)==760);
    }
    
    //Käteisostot
    //Maksu riittävä, lounaiden määrän käsittely
    
    @Test
    public void myytyjenMaukkaidenLounaidenMaaraKasvaaKunSyoMaukkaastiJaMaksaaKateisella() {
        kassa.syoMaukkaasti(1000);
        kassa.syoMaukkaasti(1000);
        assertTrue(kassa.maukkaitaLounaitaMyyty()==2);
    }
    
    @Test
    public void myytyjenEdullistenLounaidenMaaraKasvaaKunSyoEdullisestiJaMaksaaKateisella() {
        kassa.syoEdullisesti(1000);
        kassa.syoEdullisesti(1000);
        assertTrue(kassa.edullisiaLounaitaMyyty()==2);
    }
    
    //Käteisostot
    //Maksu ei riittävä, rahan käsittely
    
    @Test
    public void kassassaRahaaEiMuutuKunSyoMaukkaastiJaMaksaaKateisellaJaMaksuEiOleRiittava() {
        kassa.syoMaukkaasti(5);
        kassa.syoMaukkaasti(5);
        assertTrue(kassa.kassassaRahaa()==100000);
    }
    
    @Test
    public void kassassaRahaaEiMuutuKunSyoEdullisestiJaMaksaaKateisellaJaMaksuEiOleRiittava() {
        kassa.syoEdullisesti(5);
        kassa.syoEdullisesti(5);
        assertTrue(kassa.kassassaRahaa()==100000);
    }
    
    @Test
    public void vaihtorahanSummaKokoMaksuKunSyoMaukkaastiJaMaksaaKateisellaJaMaksuEiOleRiittava() {
        assertTrue(kassa.syoMaukkaasti(5)==5);
    }
    
    @Test
    public void vaihtorahanSummaKokoMaksuKunSyoEdullisestiJaMaksaaKateisellaJaMaksuEiOleRiittava() {
        assertTrue(kassa.syoEdullisesti(5)==5);
    }
    
    //Käteisostot
    //Maksu ei riittävä, lounaiden määrän käsittely
    
    @Test
    public void myytyjenMaukkaidenLounaidenMaaraEiKasvaKunSyoMaukkaastiJaMaksaaKateisellaJaMaksuEiOleRiittava() {
        kassa.syoMaukkaasti(5);
        kassa.syoMaukkaasti(5);
        assertTrue(kassa.maukkaitaLounaitaMyyty()==0);
    }
    
    @Test
    public void myytyjenEdullistenLounaidenMaaraEiKasvaKunSyoEdullisestiJaMaksaaKateisellaJaMaksuEiOleRiittava() {
        kassa.syoEdullisesti(5);
        kassa.syoEdullisesti(5);
        assertTrue(kassa.edullisiaLounaitaMyyty()==0);
    }
    
    //Korttiostot
    //Kortilla tarpeeksi rahaa, rahan ksäittely
    
    @Test
    public void kortinSaldoLaskeeOikeinKunSyoMaukkaastiJaMaksaaKortilla() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertTrue(kortti.saldo()==200);
    }
    
    @Test
    public void kortinSaldoLaskeeOikeinKunSyoEdullisestiJaMaksaaKortilla() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertTrue(kortti.saldo()==520);
    }
    
    @Test
    public void PalautetaanTrueKunSyoMaukkaastiJaMaksaaKortilla() {
        Maksukortti kortti = new Maksukortti(1000);
        assertTrue(kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void PalautetaanTrueKunSyoEdullisestiJaMaksaaKortilla() {
        Maksukortti kortti = new Maksukortti(1000);
        assertTrue(kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void PalautetaanTrueKunSyoMaukkaastiJaMaksaaKortillaTasarahalla() {
        Maksukortti tasarahakortti = new Maksukortti(400);
        assertTrue(kassa.syoMaukkaasti(tasarahakortti));
    }
    
    @Test
    public void PalautetaanTrueKunSyoEdullisestiJaMaksaaKortillaTasarahalla() {
        Maksukortti tasarahakortti = new Maksukortti(240);
        assertTrue(kassa.syoEdullisesti(tasarahakortti));
    }
    
    @Test
    public void kassassaRahaaEiMuutuKunSyoMaukkaastiJaMaksaaKortilla() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertTrue(kassa.kassassaRahaa()==100000);
    }
    
    @Test
    public void kassassaRahaaEiMuutuKunSyoEdullisestiJaMaksaaKortilla() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertTrue(kassa.kassassaRahaa()==100000);
    }
    
    //Korttiostot
    //Kortilla tarpeeksi rahaa, lounaiden määrän käsittely
    
    @Test
    public void myytyjenMaukkaidenLounaidenMaaraKasvaaKunSyoMaukkaastiJaMaksaaKortilla() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertTrue(kassa.maukkaitaLounaitaMyyty()==2);
    }
    
    @Test
    public void myytyjenEdullistenLounaidenMaaraKasvaaKunSyoEdullisestiJaMaksaaKortilla() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertTrue(kassa.edullisiaLounaitaMyyty()==2);
    }
    
    //Korttiostot
    //Kortilla ei tarpeeksi rahaa, rahan määrän käsittely
    
    @Test
    public void kortinSaldoEiMuutuKunSyoMaukkaastiJaMaksaaKortillaJaKortillaEiTarpeeksiRahaa() {
        Maksukortti vajaaKortti = new Maksukortti(5);
        kassa.syoMaukkaasti(vajaaKortti);
        kassa.syoMaukkaasti(vajaaKortti);
        assertTrue(vajaaKortti.saldo()==5);
    }
    
    @Test
    public void kortinSaldoEMuutuKunSyoEdullisestiJaMaksaaKortillaJaKortillaEiTarpeeksiRahaa() {
        Maksukortti vajaaKortti = new Maksukortti(5);
        kassa.syoEdullisesti(vajaaKortti);
        kassa.syoEdullisesti(vajaaKortti);
        assertTrue(vajaaKortti.saldo()==5);
    }
    
    @Test
    public void PalautetaanFalseKunSyoMaukkaastiJaMaksaaKortillaJaKortillaEiTarpeeksiRahaa() {
        Maksukortti vajaaKortti = new Maksukortti(5);
        assertFalse(kassa.syoMaukkaasti(vajaaKortti));
    }
    
    @Test
    public void PalautetaanFalseKunSyoEdullisestiJaMaksaaKortillaJaKortillaEiTarpeeksiRahaa() {
        Maksukortti vajaaKortti = new Maksukortti(5);
        assertFalse(kassa.syoEdullisesti(vajaaKortti));
    }
    
    @Test
    public void kassassaRahaaEiMuutuKunSyoMaukkaastiJaMaksaaKortillaJaKortillaEiTarpeeksiRahaa() {
        Maksukortti vajaaKortti = new Maksukortti(5);
        kassa.syoMaukkaasti(vajaaKortti);
        kassa.syoMaukkaasti(vajaaKortti);
        assertTrue(kassa.kassassaRahaa()==100000);
    }
    
    @Test
    public void kassassaRahaaEiMuutuKunSyoEdullisestiJaMaksaaKortillaJaKortillaEiTarpeeksiRahaa() {
        Maksukortti vajaaKortti = new Maksukortti(5);
        kassa.syoEdullisesti(vajaaKortti);
        kassa.syoEdullisesti(vajaaKortti);
        assertTrue(kassa.kassassaRahaa()==100000);
    }
    
    //Korttiostot
    //Kortilla ei tarpeeksi rahaa, lounaiden määrän käsittely
    
    @Test
    public void myytyjenMaukkaidenLounaidenMaaraEiKasvaKunSyoMaukkaastiJaMaksaaKortillaJaKortillaEiTarpeeksiRahaa() {
        Maksukortti vajaaKortti = new Maksukortti(5);
        kassa.syoMaukkaasti(vajaaKortti);
        kassa.syoMaukkaasti(vajaaKortti);
        assertTrue(kassa.maukkaitaLounaitaMyyty()==0);
    }
    
    @Test
    public void myytyjenEdullistenLounaidenMaaraEiKasvaKunSyoEdullisestiJaMaksaaKortillaJaKortillaEiTarpeeksiRahaa() {
        Maksukortti vajaaKortti = new Maksukortti(5);
        kassa.syoEdullisesti(vajaaKortti);
        kassa.syoEdullisesti(vajaaKortti);
        assertTrue(kassa.edullisiaLounaitaMyyty()==0);
    }
    
    //Rahan lataus kortille
    
    @Test
    public void kassassaRahaaMuuttuuKunLataaRahaaKortille() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.lataaRahaaKortille(kortti, 2000);
        assertTrue(kassa.kassassaRahaa()==102000);
    }
    
    @Test
    public void kassassaRahaaEiMuutuKunLataaRahaaKortilleNegatiivisenSumman() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.lataaRahaaKortille(kortti, -500);
        assertTrue(kassa.kassassaRahaa()==100000);
    }
    
    @Test
    public void kortinSaldoMuuttuuKunLataaRahaaKortille() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.lataaRahaaKortille(kortti, 2000);
        assertTrue(kortti.saldo()==3000);
    }
    
    @Test
    public void kortinSaldoEiMuutuKunLataaRahaaKortilleNegatiivisenSumman() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.lataaRahaaKortille(kortti, -500);
        assertTrue(kortti.saldo()==1000);
    }
}
