import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper{

    Context context;
    private final static String dataName = "partida.db";
    private final static String tabla_name = "CREATE TABLE JUEGO (ID INTEGER PRIMARY KEY AUTOINCREMENT, PUNTAJE DOUBLE)";
    private final static int version = 1;

    public  DataBase(Context context){
        super(context, dataName, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla_name);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CREATE"+tabla_name);
        db.execSQL(tabla_name);
    }


    public void guardar (double puntaje){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("PUNTAJE", puntaje);
        db.insert("JUEGO", null, values);
    }

    public Cursor puntajes(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;

        String dato []= {"PUNTAJE"};
        String orderBy = "PUNTAJE DESC";
        String limite = "5";
        try {
            cursor= db.query("JUEGO", dato, null, null, null, orderBy, limite);
            return  cursor;
        } catch (Exception e){}

        return null;
    }
}
