# Bibliotekshanteraren

Det här projektet är ett enkelt bibliotekssystem byggt i Java.

## Funktioner

Programmet kan:

- Lägga till böcker
- Registrera medlemmar
- Låna böcker
- Lämna tillbaka böcker
- Söka efter böcker
- Visa alla böcker och deras status
- Hantera felaktig inmatning

## Teknik

Projektet är byggt med:

- Java
- Objektorienterad programmering
- Arrays
- Maven
- IntelliJ IDEA

## Design

### Book

`Book` är en `record` eftersom en bok främst innehåller data:
ISBN, titel och författare.

En `record` passar bra eftersom Java automatiskt skapar bland annat
constructor och metoder för att läsa värdena.

### Member

`Member` är en vanlig klass eftersom en medlem har data och även
beteende, till exempel hur många böcker medlemmen har lånat.

Fälten är `private` för att använda inkapsling.

### Library

`Library` använder vanliga arrayer för att lagra böcker och medlemmar.
Projektet använder inte `ArrayList`, eftersom uppgiften kräver vanliga
arrayer.

## Felhantering

Programmet hanterar felaktiga menyval och felaktiga nummer så att
programmet inte kraschar.

## Sammanfattning

Projektet är ett enkelt CLI-bibliotekssystem där användaren kan hantera
böcker och medlemmar genom en meny.

## Lärdomar

Under arbetet med projektet har jag tränat på Java, klasser, records,
metoder, arrayer och felhantering.

Jag har fått träna på Git och Maven och att bygga ett enkelt
program med en interaktiv meny.