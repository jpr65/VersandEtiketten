using Daten;
using IO_Operationen;
using Operationen;

namespace Integration
{
    public class VersandEtikettenErsteller
    {
        public int EtikettZaehler { get; private set; }

        public MiddleWareInterface middleWare = IoFactory.getMiddleWare();

        public EtikettVariante1 VersandEtikettVariante1(String? kundeID, String? adresseID, String? laenderKennung, String? weitereID)
        {
            EtikettVariante1 erstelltesEtikett = this.ErzeugeNeuesEtikett();
		
		erstelltesEtikett.AnschriftZeilen = this.AnschriftErstellung(kundeID, adresseID, laenderKennung);
		
		return erstelltesEtikett;
	}

    private EtikettVariante1 ErzeugeNeuesEtikett()
    {
        EtikettVariante1 erstelltesEtikett = new EtikettVariante1();

        erstelltesEtikett.EtikettNr = ++this.EtikettZaehler;

        return erstelltesEtikett;
    }

    public List<String?>? AnschriftErstellung(String? kundeID, String? adresseID, String? laenderKennung)
    {
        Kunde kunde = middleWare.LeseKunde(kundeID);
        Adresse adresse = middleWare.LeseAdresse(adresseID);

        IAnschriftFormatierer anschriftFormatierer = OperatorFactory.buildAnschriftFormatierer(laenderKennung);
		
		return anschriftFormatierer.AnschriftErstellung(kunde, adresse);
    }
}
}