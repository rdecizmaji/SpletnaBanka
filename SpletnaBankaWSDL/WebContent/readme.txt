Opis funkcij

---***Eracuni***---


public String izdajERacun(String izd,String pre,int stRacuna,String krajizdaje,String nacinplacila,int kodanamena, String referenca,Calendar datumod,Calendar datumdo,Calendar datumzap, List<Postavka> postavke)

VHOD:
izd - trr izdajatelja
pre - trr prejemnika
stRacun - stevilka racuna
krajizdaje - kraj izdaje
nacinplacila - nacin placila
int kodanamena - IDji kode namena v (assets/kodenamena.html)
referenca - referenca
datumod - datum od začetka opravljanja storitve
datumdo - datum do konca opravljanja storitve
datumzap - datum zapadlosti
postavke - postavke (assets/primerpostavke.html)
IZHOD: Obvestilo o uspešno izdanem računu

public List <ERacun> vrniRacune(String trr, int option)

VHOD:
trr - trr racuna
option : 1-placani, 2-neplacani, 3-vsi

IZHOD: List <Racun>

//////////////////////////////////////////////////////////////////////////////////////////////////////////

---***Transakcije***---

public String izvrsiNalog(String trr, String trrp, String namen,BigDecimal znesek )

VHOD:
trr - trr placnika
trrp- trr
znesek - znesek

IZHOD: Obvestilo o uspešno izvršeni transakciji

public List <Transakcija> vrniTransakcije(String trr)

VHOD:
trr - trr

IZHOD List<Transakcija>