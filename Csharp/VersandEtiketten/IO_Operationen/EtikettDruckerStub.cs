namespace IO_Operationen
{
    /// <summary>
    /// IO-Operation: Stub eines Etikettdruckers für die Demo
    //
    /// Hier würde üblicherweise ein Interface
    /// zu einem echten Drucker bedient.
    /// </summary>
    public class EtikettDruckerStub : IEtikettDrucker
    {
        public void DruckeEtikett(List<String?> etikettZeilen)
        {
            foreach (String? anschriftZeile in etikettZeilen) 
            { 
                Console.WriteLine(anschriftZeile);
            }

            Console.WriteLine("------------------------------------------");
        }
    }
}