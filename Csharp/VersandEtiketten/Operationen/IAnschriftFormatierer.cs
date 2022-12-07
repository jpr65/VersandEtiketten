using Daten;
using System.Text;

namespace Operationen
{
    /// <summary>
    /// Interface für die Anschrift-Formatierer,
    /// für jedes Land wird ein eigener Formatierer implementiert
    /// </summary>
    public interface IAnschriftFormatierer
        {
            public String GetLaenderKennung();
            public List<String?> AnschriftErstellung(Kunde KundeArg, Adresse AdresseArg);
        }
}
