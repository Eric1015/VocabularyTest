package hangman.love1.longmandictionaryvocabularytest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by love1 on 2018/03/18.
 */

public class VocabularyTestDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Vocabulary_Test";

    VocabularyTestDatabaseHelper(Context context){
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE VOCABULARY (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "CATEGORY TEXT, "
                + "RESOURCE_ID INTEGER);");
        insertWord(db, "lion", "Animals", R.drawable.lion);
        insertWord(db, "bison", "Animals", R.drawable.bison);
        insertWord(db, "duck", "Animals", R.drawable.duck);
        insertWord(db, "tiger", "Animals", R.drawable.tiger);
        insertWord(db, "doctor", "Occupation", R.drawable.doctor);
        insertWord(db, "police_officer", "Occupation", R.drawable.police_officer);
        insertWord(db, "model", "Occupation", R.drawable.model);
        insertWord(db, "teacher", "Occupation", R.drawable.teacher);
        insertWord(db, "pizza", "Food", R.drawable.pizza);
        insertWord(db, "spaghetti", "Food", R.drawable.spaghetti);
        insertWord(db, "hamburger", "Food", R.drawable.hamburger);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS VOCABULARY");
        onCreate(db);
    }

    private void insertWord(SQLiteDatabase db, String name, String category, int resourceId){
        ContentValues wordValues = new ContentValues();
        wordValues.put("Name", name);
        wordValues.put("CATEGORY", category);
        wordValues.put("RESOURCE_ID", resourceId);
        db.insert("VOCABULARY", null, wordValues);
    }

    public Cursor getCursorByCategory(String category){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("VOCABULARY",
                new String[] {"NAME", "CATEGORY", "RESOURCE_ID"},
                "CATEGORY = ?",
                new String[]{category},
                null, null, null);
        return cursor;
    }
}
