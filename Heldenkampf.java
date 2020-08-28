public class Heldenkampf {

  public static void main(String[] args) {  
    // Schreibe Held A
    String[] boeseGut = {"boese","gut"};

    Held a = new Held("Cethegus", 100, 70, 95, false, boeseGut);
    
    // Schreibe Held B
    Held b = new Held("Teja", 100, 95, 75, true, boeseGut);

    // Schleife -> Solange Helden am Leben  
       for (boolean isHeldAlive = true; isHeldAlive == true ; ) {
        double bAusweichwert = ((((double)b.getGeschicklichkeit()) * 0.03)  + (20 * Math.random()));
        boolean isBAusgewichen = bAusweichwert >= 18;
        if (isBAusgewichen) {
           System.out.println(a.getName() + " greift " + b.getName() + " an.");
           System.out.println (b.getName() + " ist ausgewichen!");
        }
        else {
          int aSchaden = (int)(((double) a.getKraft() * (0.05 + (0.1 *  Math.random()))) + 0.5);
                
          int bNeueGesundheit =  b.getGesundheit() - aSchaden;
          
          if (bNeueGesundheit < 0) {
            bNeueGesundheit = 0;
          }
  
          b.setGesundheit(bNeueGesundheit);      
      
          System.out.println(a.getName() + " greift " + b.getName() + " an. Er erleidet " + aSchaden + " Schaden!\n" +
                          "Er hat noch " + bNeueGesundheit + " Gesundheit!");
         if (bNeueGesundheit <= 0) {
           //Endsequenz Ausgabe
           System.out.println(b.getName() + " stirbt!");
           System.out.println(b.getName() + ": Nein, das kann nicht sein! Arrrrgs!");
           isHeldAlive = false;
           break;
         }
      }
      
      double aAusweichwert = ((double) a.getGeschicklichkeit() * 0.03  + (20 * Math.random()));
      boolean isAAusgewichen = aAusweichwert >= 18;
      
        if (isAAusgewichen) {
           System.out.println(b.getName() + " greift " + a.getName() + " an.");
           System.out.println (a.getName() + " ist ausgewichen!");
        }
        else {
            int bSchaden = (int)(((double) b.getKraft() * (0.05 + (0.1 *  Math.random()))) + 0.5);
            
            int aNeueGesundheit =  a.getGesundheit() - bSchaden;
            
            if (aNeueGesundheit<0) {
              aNeueGesundheit = 0;
            }
            
            a.setGesundheit(aNeueGesundheit);
              
            System.out.println( b.getName() + " greift " + a.getName() + " an. Er erleidet " + bSchaden + " Schaden!\n" +
                                "Er hat noch " + aNeueGesundheit + " Lebenspunkte!");
            
            
            if (aNeueGesundheit <= 0) {
               //Endsequenz Ausgabe    
               System.out.println(b.getName() + " stirbt!");
               System.out.println(b.getName() + ": Ein ehrenhafter Kampf, ich nehme mein Schicksal an!");
               isHeldAlive = false;      
            }
        }
    } // end of for
  }
}
