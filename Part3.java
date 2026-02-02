public class Part3 
{
    
    /**
     * Checks if stringa appears at least twice in stringb.
     * 
     * @param stringa the string to search for
     * @param stringb the string to search in
     * @return true if stringa appears at least twice in stringb, false otherwise
     */
    public boolean twoOccurrences(String stringa, String stringb) 
    {
        // Find the first occurrence of stringa in stringb
        int firstIndex = stringb.indexOf(stringa);
        
        // If stringa is not found at all, return false
        if (firstIndex == -1) 
        {
            return false;
        }
        
        // Search for a second occurrence starting after the first one
        int secondIndex = stringb.indexOf(stringa, firstIndex + stringa.length());
        
        // Return true if a second occurrence was found
        return secondIndex != -1;
    }
    
    /**
     * Finds the first occurrence of stringa in stringb and returns the part
     * of stringb that follows stringa. If stringa does not occur in stringb,
     * returns stringb.
     * 
     * @param stringa the string to search for
     * @param stringb the string to search in
     * @return the part of stringb after the first occurrence of stringa,
     *         or stringb if stringa is not found
     */
    public String lastPart(String stringa, String stringb) 
    {
        // Find the first occurrence of stringa in stringb
        int index = stringb.indexOf(stringa);
        
        // If stringa is not found, return stringb
        if (index == -1) 
        {
            return stringb;
        }
        
        // Return the part of stringb that follows stringa
        return stringb.substring(index + stringa.length());
    }
    
    /**
     * Tests the twoOccurrences and lastPart methods with various string pairs.
     */
    public void testing() 
    {
        // Testing twoOccurrences method
        System.out.println("Testing twoOccurrences method:");
        System.out.println("-------------------------------");
        
        // Test case 1: "by" appears twice in the string (should be true)
        String a1 = "by";
        String b1 = "A story by Abby Long";
        System.out.println("twoOccurrences(\"" + a1 + "\", \"" + b1 + "\") = " + twoOccurrences(a1, b1));
        
        // Test case 2: "a" appears three times (should be true)
        String a2 = "a";
        String b2 = "banana";
        System.out.println("twoOccurrences(\"" + a2 + "\", \"" + b2 + "\") = " + twoOccurrences(a2, b2));
        
        // Test case 3: "atg" appears only once (should be false)
        String a3 = "atg";
        String b3 = "ctgtatgta";
        System.out.println("twoOccurrences(\"" + a3 + "\", \"" + b3 + "\") = " + twoOccurrences(a3, b3));
        
        // Test case 4: "an" appears twice (should be true)
        String a4 = "an";
        String b4 = "banana";
        System.out.println("twoOccurrences(\"" + a4 + "\", \"" + b4 + "\") = " + twoOccurrences(a4, b4));
        
        // Test case 5: "xyz" does not appear (should be false)
        String a5 = "xyz";
        String b5 = "hello world";
        System.out.println("twoOccurrences(\"" + a5 + "\", \"" + b5 + "\") = " + twoOccurrences(a5, b5));
        
        System.out.println();
        
        // Testing lastPart method
        System.out.println("Testing lastPart method:");
        System.out.println("------------------------");
        
        // Test case 1: "an" in "banana" returns "ana"
        String p1 = "an";
        String q1 = "banana";
        System.out.println("The part of the string after " + p1 + " in " + q1 + " is " + lastPart(p1, q1) + ".");
        
        // Test case 2: "zoo" not in "forest" returns "forest"
        String p2 = "zoo";
        String q2 = "forest";
        System.out.println("The part of the string after " + p2 + " in " + q2 + " is " + lastPart(p2, q2) + ".");
        
        // Test case 3: "be" in "iceberg" returns "rg"
        String p3 = "be";
        String q3 = "iceberg";
        System.out.println("The part of the string after " + p3 + " in " + q3 + " is " + lastPart(p3, q3) + ".");
        
        // Test case 4: "the" in "at the end" returns " end"
        String p4 = "the";
        String q4 = "at the end";
        System.out.println("The part of the string after " + p4 + " in " + q4 + " is " + lastPart(p4, q4) + ".");
        
        // Test case 5: "java" at the end returns empty string
        String p5 = "java";
        String q5 = "I love java";
        System.out.println("The part of the string after " + p5 + " in " + q5 + " is " + lastPart(p5, q5) + ".");
    }
    
    public static void main(String[] args) 
    {
        Part3 part3 = new Part3();
        part3.testing();
    }
}
