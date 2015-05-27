import processing.core.*;
import processing.pdf.*;
import java.util.*;

public class CardMake extends PApplet {
  
  private Random rand;
  private ArrayList<PImage> images;
  private PImage bground;
  private PFont font;
  private ArrayList<String> names;
  private String[] names1 = {  "Sacramento",
                               "Big Sur",
                               "Death Valley",
                               "Disneyland",
                               "Mount Whitney",
                               "Golden Gate \nBridge",
                               "Golden Poppy",
                               "Gray Whale",
                               "Grizzly Bear",
                               "Hollywood",
                               "Los Angeles",
                               "Orange",
                               "Pacific Ocean",
                               "Gold Rush",
                               "Purple \nNeedlegrass",
                               "Redwood Trees",
                               "Robert Frost",
                               "Beach",
                               "Surfing",
                               "San \nFrancisco",
                               "The 31st \nState" };

  public void setup() {
    rand = new Random();
    size(1275, 1753, PDF, "calibingo.pdf");
    textMode(SHAPE);
    frameRate(30);
    font = createFont("FreeSans",15);
    textFont(font, 15);
    fill(0);
    bground = loadImage("calibingo.jpg");
  }

  public void draw() {
    image(bground,0,0);
    images = new ArrayList<PImage>();
    for (int i = 0; i < 21; i++) {
      images.add(loadImage(i + ".jpg"));
    }
    names = new ArrayList<String>();
    for(int i = 0; i < 21; i++) {
      names.add(names1[i]);
    }
    float padding = 0;
    int choice;
    PImage next;
    String nextCap;
    for (int i = 0; i < 16; i++) {
      line(250, 206.25*(i/4) + 400, 1000,  206.25*(i/4) + 400);
      line(187.25*(i%4)+ 250, 400, 187.25*(i%4) + 250, 1225);
      choice = random.nextInt(images.size());
      next = images.remove(choice);
      nextCap = names.remove(choice);
      padding = (187.5 - next.width) / 2; 
      image(next, 187.5*(i % 4) + padding + 250, 206.25*(i/4) + 5 + 400);
      text(nextCap, 187.5*(i % 4) + 10 + 250, 206.25*(i/4) + 180 + 395);
    }
    line(250,1225,1000,1225);
    line(1000,400,1000,1225);
    PGraphicsPDF pdf = (PGraphicsPDF) g;  // Get the renderer
    pdf.nextPage();  // Tell it to go to the next page
    if (frameCount == 35) {
      System.out.println("FInished");
      exit();
    }
  }

  public static void main(String[] args) {
    PApplet.main(new String[] {"--present", "CardMake"});
  }
} 
