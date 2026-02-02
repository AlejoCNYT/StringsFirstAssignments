public class Part2 
{
    
    /**
     * Finds a simple gene in a DNA string.
     * A valid gene starts with the start codon, ends with the stop codon, and has a length
     * (between start and stop codons) that is a multiple of 3.
     * Works with both uppercase and lowercase DNA strings.
     * 
     * @param dna the DNA string to search
     * @param startCodon the start codon (e.g., "ATG")
     * @param stopCodon the stop codon (e.g., "TAA")
     * @return the gene substring if found, or an empty string if not found
     */
    public String findSimpleGene(String dna, String startCodon, String stopCodon) 
    {
        // Convert DNA and codons to uppercase for comparison purposes
        String dnaUpper = dna.toUpperCase();
        String startCodonUpper = startCodon.toUpperCase();
        String stopCodonUpper = stopCodon.toUpperCase();
        
        // Find the index position of the start codon
        int startIndex = dnaUpper.indexOf(startCodonUpper);
        if (startIndex == -1)
        {
            return "";
        }
        
        // Find the index position of the first stop codon appearing after the start codon
        int stopIndex = dnaUpper.indexOf(stopCodonUpper, startIndex + 3);
        if (stopIndex == -1) 
        {
            return "";
        }
        
        // Check if the length of the substring between start and stop codons is a multiple of 3
        // The gene includes both codons, so we check from startIndex to stopIndex + 3
        int geneLength = stopIndex + 3 - startIndex;
        if (geneLength % 3 == 0) 
        {
            // Return the gene from the original DNA string to preserve the original case
            return dna.substring(startIndex, stopIndex + 3);
        }
        
        return "";
    }
    
    /**
     * Tests the findSimpleGene method with various DNA strings
     * covering different test cases including uppercase and lowercase.
     */
    public void testSimpleGene() 
    {
        String startCodon = "ATG";
        String stopCodon = "TAA";
        
        // Test case 1: DNA with no "ATG"
        String dna1 = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("DNA: " + dna1);
        System.out.println("Gene: " + findSimpleGene(dna1, startCodon, stopCodon));
        System.out.println();
        
        // Test case 2: DNA with no "TAA"
        String dna2 = "ATGCCCGGGCCC";
        System.out.println("DNA: " + dna2);
        System.out.println("Gene: " + findSimpleGene(dna2, startCodon, stopCodon));
        System.out.println();
        
        // Test case 3: DNA with no "ATG" or "TAA"
        String dna3 = "CCCGGGCCCGGG";
        System.out.println("DNA: " + dna3);
        System.out.println("Gene: " + findSimpleGene(dna3, startCodon, stopCodon));
        System.out.println();
        
        // Test case 4: DNA with ATG, TAA and substring between them IS a multiple of 3 (valid gene)
        String dna4 = "CCCATGCCCGGGTAACCC";
        System.out.println("DNA: " + dna4);
        System.out.println("Gene: " + findSimpleGene(dna4, startCodon, stopCodon));
        System.out.println();
        
        // Test case 5: DNA with ATG, TAA and substring between them is NOT a multiple of 3
        String dna5 = "ATGCCTAA";
        System.out.println("DNA: " + dna5);
        System.out.println("Gene: " + findSimpleGene(dna5, startCodon, stopCodon));
        System.out.println();
        
        // Test case 6: Uppercase DNA - should return uppercase gene
        String dna6 = "ATGGGTTAAGTC";
        System.out.println("DNA: " + dna6);
        System.out.println("Gene: " + findSimpleGene(dna6, startCodon, stopCodon));
        System.out.println();
        
        // Test case 7: Lowercase DNA - should return lowercase gene
        String dna7 = "gatgctataat";
        System.out.println("DNA: " + dna7);
        System.out.println("Gene: " + findSimpleGene(dna7, startCodon, stopCodon));
        System.out.println();
    }
    
    public static void main(String[] args) 
    {
        Part2 part2 = new Part2();
        part2.testSimpleGene();
    }
}
