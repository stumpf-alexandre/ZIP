package ZIP;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Compactador.compactarZip("C:\\zipado.zip", "C:\\zipado.txt");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
