namespace TestAPI
{
    [TestClass]
    public class TCA_010_StringUtil
    {
        [TestMethod]
        public void T020_ToUpperCase()
        {
            Assert.AreEqual(null, StringUtil.ToUpperCase(null));
            Assert.AreEqual("", StringUtil.ToUpperCase(""));
            Assert.AreEqual(" ", StringUtil.ToUpperCase(" "));
            Assert.AreEqual("\t", StringUtil.ToUpperCase("\t"));

            Assert.AreEqual("A", StringUtil.ToUpperCase("a"));
            Assert.AreEqual("1", StringUtil.ToUpperCase("1"));
            Assert.AreEqual(" B ", StringUtil.ToUpperCase(" b "));
            Assert.AreEqual("TEXT", StringUtil.ToUpperCase("text"));
            Assert.AreEqual("TEXT", StringUtil.ToUpperCase("Text"));
            Assert.AreEqual("TEXT", StringUtil.ToUpperCase("TEXT"));

            Assert.AreEqual("BRÖTCHEN", StringUtil.ToUpperCase("Brötchen"));
            Assert.AreEqual("SMÅLAND", StringUtil.ToUpperCase("Småland"));
        }


        [TestMethod]
        public void T100_AddOptionalPart_StrStr_empty()
        {
            Assert.AreEqual(null, StringUtil.AddOptionalPart(null, null));
            Assert.AreEqual("", StringUtil.AddOptionalPart("", null));
            Assert.AreEqual("\t", StringUtil.AddOptionalPart(null, "\t"));
            Assert.AreEqual(" ", StringUtil.AddOptionalPart(null, " "));

            Assert.AreEqual("", StringUtil.AddOptionalPart("", ""));
            Assert.AreEqual("  ", StringUtil.AddOptionalPart(" ", " "));
        }

        [TestMethod]
        public void T110_AddOptionalPart_StrStr_1stEmpty()
        {
            Assert.AreEqual("A", StringUtil.AddOptionalPart(null, "A"));
            Assert.AreEqual("B", StringUtil.AddOptionalPart("", "B"));
            Assert.AreEqual("\tC", StringUtil.AddOptionalPart("\t", "C"));
            Assert.AreEqual(" D", StringUtil.AddOptionalPart(" ", "D"));
        }

        [TestMethod]
        public void T120_AddOptionalPart_StrStr_2ndEmpty()
        {
            Assert.AreEqual("A", StringUtil.AddOptionalPart("A", null));
            Assert.AreEqual("B", StringUtil.AddOptionalPart("B", ""));
            Assert.AreEqual("C\t", StringUtil.AddOptionalPart("C", "\t"));
            Assert.AreEqual("D ", StringUtil.AddOptionalPart("D", " "));
        }

        [TestMethod]
        public void T130_AddOptionalPart_StrStr()
        {
            Assert.AreEqual("A B", StringUtil.AddOptionalPart("A", "B"));
            Assert.AreEqual("C   D", StringUtil.AddOptionalPart("C ", " D"));

            Assert.AreEqual("Herbert Meyer", StringUtil.AddOptionalPart("Herbert", "Meyer"));
            Assert.AreEqual("Kirch AG", StringUtil.AddOptionalPart("", "Kirch AG"));
        }

        [TestMethod]
        public void T200_AddOptionalPart_StrStrStr_nulls()
        {
            Assert.AreEqual(null, StringUtil.AddOptionalPart(null, null, null));

            Assert.AreEqual("", StringUtil.AddOptionalPart("", null, null));
            Assert.AreEqual("\t", StringUtil.AddOptionalPart("\t", null, null));
            Assert.AreEqual(" ", StringUtil.AddOptionalPart(" ", null, null));
            Assert.AreEqual("B", StringUtil.AddOptionalPart("B", null, null));
            Assert.AreEqual("ü", StringUtil.AddOptionalPart("ü", null, null));

            Assert.AreEqual("", StringUtil.AddOptionalPart(null, "", null));
            Assert.AreEqual("\t", StringUtil.AddOptionalPart(null, "\t", null));
            Assert.AreEqual(" ", StringUtil.AddOptionalPart(null, " ", null));
            Assert.AreEqual("C", StringUtil.AddOptionalPart(null, "C", null));
            Assert.AreEqual("ä", StringUtil.AddOptionalPart(null, "ä", null));

            Assert.AreEqual("", StringUtil.AddOptionalPart("", "", null));
            Assert.AreEqual("  ", StringUtil.AddOptionalPart(" ", " ", null));
            Assert.AreEqual("ef", StringUtil.AddOptionalPart("e", "f", null));
        }

        [TestMethod]
        public void T210_AddOptionalPart_StrStrStr()
        {
            Assert.AreEqual("A", StringUtil.AddOptionalPart("A", "", ""));
            Assert.AreEqual("B", StringUtil.AddOptionalPart("", "B", ""));
            Assert.AreEqual("CD", StringUtil.AddOptionalPart("C", "D", ""));
            Assert.AreEqual("E-F", StringUtil.AddOptionalPart("E", "F", "-"));
            Assert.AreEqual("G\tH", StringUtil.AddOptionalPart("G", "H", "\t"));

            Assert.AreEqual("Meyer, Herbert", StringUtil.AddOptionalPart("Meyer", "Herbert", ", "));
            Assert.AreEqual("Kirch-AG", StringUtil.AddOptionalPart("Kirch", "AG", "-"));
        }
    }
}