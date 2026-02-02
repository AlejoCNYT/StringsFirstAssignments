# Strings First Assignments

A Java project for string manipulation exercises. Contains solutions to problems involving DNA gene finding, substring search, and URL extraction from web content.

## Overview

This repository implements four main exercises focused on working with strings in Java:

| Part | Description |
|------|-------------|
| **Part1** | Find simple genes in DNA strings (fixed codons ATG/TAA) |
| **Part2** | Find genes with configurable start/stop codons (case-insensitive) |
| **Part3** | String utilities: occurrence checking and substring extraction |
| **Part4** | Extract YouTube URLs from a web page |

## Project Structure

```
StringsFirstAssignments/
├── Part1.java    # DNA gene finder (ATG/TAA)
├── Part2.java    # Configurable gene finder
├── Part3.java    # twoOccurrences & lastPart
├── Part4.java    # YouTube URL extractor
└── README.md
```

## Requirements

- **Java** 8 or higher
- **Part4 only**: Duke University Coursera library (`edu.duke.URLResource`) — required for reading web pages

## Usage

Each class can be run independently:

```bash
# Part 1: Find genes in DNA (ATG...TAA)
javac Part1.java
java Part1

# Part 2: Find genes with custom codons (uppercase/lowercase)
javac Part2.java
java Part2

# Part 3: String occurrence and substring methods
javac Part3.java
java Part3

# Part 4: Extract YouTube links from a web page
javac Part4.java
java Part4
```

> **Note:** Part4 requires the Duke Coursera library in the classpath. If you don't have it, run only Part1, Part2, and Part3.

## Part Details

### Part 1 – Simple Gene Finder

Finds a valid gene in a DNA string. A gene is valid when:
- Starts with codon **ATG**
- Ends with codon **TAA**
- Length between start and stop (inclusive) is a multiple of 3

### Part 2 – Configurable Gene Finder

Extends Part1 with:
- Custom start and stop codons as parameters
- Case-insensitive matching (works with uppercase and lowercase DNA)
- Original case preserved in the returned gene

### Part 3 – String Utilities

- **`twoOccurrences(stringa, stringb)`**: Returns `true` if `stringa` appears at least twice in `stringb`
- **`lastPart(stringa, stringb)`**: Returns the substring of `stringb` after the first occurrence of `stringa`, or `stringb` if not found

### Part 4 – YouTube URL Extractor

Reads an HTML page and prints all URLs that point to `youtube.com`. Uses `URLResource` to fetch and parse the page word by word.

## License

Educational project — use as needed for learning purposes.
