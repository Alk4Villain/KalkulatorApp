import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class kalkulator {
    // Fungsi untuk melakukan perhitungan matematika menggunakan ScriptEngine
    public String hitung(String ekspresi) {
        try {
            // Validasi ekspresi matematika
            if (ekspresi.matches("[0-9+\\-*/.()]+")) {
                ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
                Object result = engine.eval(ekspresi);
                return result.toString();
            } else {
                return "Invalid Input";
            }
        } catch (ScriptException ex) {
            return "Error";
        }
    }
}
