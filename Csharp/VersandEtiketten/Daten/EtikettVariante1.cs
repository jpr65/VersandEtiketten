namespace Daten
{
    public class EtikettVariante1
    {
        public List<String?>? AnschriftZeilen { get; set; }

        public int EtikettNr { get; set; } = 0;
        // weitere Daten

        // Methoden

        //i/ Eine solche Methode ist hier erlaubt, denn es werden
        //i/ nur eigene Daten betrachtet.
        //i/ Sie könnte aber auch als eine eigene Operation ausgelagert werden,
        //i/ falls die Methode komplexer wird oder aber verschiedene
        //i/ Implementierungen/Varianten möglich sind.

        public int BelegteZeilenAnz()
        {
            int zeilenBelegtCounter = 0;

            if (AnschriftZeilen == null)
            {
                return 0;
            }

            foreach (String? anschriftZeile in AnschriftZeilen)
            {

                if (!String.IsNullOrWhiteSpace(anschriftZeile))
                {
                    zeilenBelegtCounter++;
                }
            }

            return zeilenBelegtCounter;
        }
    }
}
