package Spring.home.hm2;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HelloService {
    private  Random  r = new Random();
    private  String[] listFonts = {"Arial","Verdana","ARIAL BLACK","fantasy"};
    private String[] pixels = {"33px", "41pt","55pt","69pt","90pt"};
    private String[] colors = {"red","blue","black","pink"};
    public String getHello(String str) {
        String font = getFonts();
        String size = getPX();
        String color = getColors();
        return String.format("<div style='text-align: center; font-family: %s; font-size: %s; color: %s;'>%s</div>", font, size, color, str);
    }

    private String getFonts(){
        return listFonts[r.nextInt(listFonts.length)];
    }

    private String getPX(){
        return pixels[r.nextInt(pixels.length)];
    }

    private String getColors(){
        return colors[r.nextInt(colors.length)];
    }

}
