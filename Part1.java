public class Part1 {
    
    /**
     * Finds a simple gene in a DNA string.
     * A valid gene starts with "ATG", ends with "TAA", and has a length
     * (between start and stop codons) that is a multiple of 3.
     * 
     * @param dna the DNA string to search
     * @return the gene substring if found, or an empty string if not found
     */
    public String findSimpleGene(String dna) {
        // Find the index position of the start codon "ATG"
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }
        
        // Find the index position of the first stop codon "TAA" appearing after "ATG"
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        if (stopIndex == -1) {
            return "";
        }
        
        // Check if the length of the substring between "ATG" and "TAA" is a multiple of 3
        // The gene includes both codons, so we check from startIndex to stopIndex + 3
        int geneLength = stopIndex + 3 - startIndex;
        if (geneLength % 3 == 0) {
            return dna.substring(startIndex, stopIndex + 3);
        }
        
        return "";
    }
    
    /**
     * Tests the findSimpleGene method with five different DNA strings
     * covering various test cases.
     */
    public void testSimpleGene() {
        // Test case 1: DNA with no "ATG"
        String dna1 = "CCCGGGTAACCC";
        System.out.println("DNA: " + dna1);
        System.out.println("Gene: " + findSimpleGene(dna1));
        System.out.println();
        
        // Test case 2: DNA with no "TAA"
        String dna2 = "ATGCCCGGGCCC";
        System.out.println("DNA: " + dna2);
        System.out.println("Gene: " + findSimpleGene(dna2));
        System.out.println();
        
        // Test case 3: DNA with no "ATG" or "TAA"
        String dna3 = "CCCGGGCCCGGG";
        System.out.println("DNA: " + dna3);
        System.out.println("Gene: " + findSimpleGene(dna3));
        System.out.println();
        
        // Test case 4: DNA with ATG, TAA and substring between them IS a multiple of 3 (valid gene)
        String dna4 = "CCCATGCCCGGGTAACCC";
        System.out.println("DNA: " + dna4);
        System.out.println("Gene: " + findSimpleGene(dna4));
        System.out.println();
        
        // Test case 5: DNA with ATG, TAA and substring between them is NOT a multiple of 3
        String dna5 = "ATGCCTAA";
        System.out.println("DNA: " + dna5);
        System.out.println("Gene: " + findSimpleGene(dna5));
        System.out.println();
    }
    
    public static void main(String[] args) {
        Part1 part1 = new Part1();
        part1.testSimpleGene();
    }
}
