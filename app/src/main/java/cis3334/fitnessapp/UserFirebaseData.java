package cis3334.fitnessapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by evangelistachicheko on 4/27/17.
 */


public class UserFirebaseData {
    DatabaseReference myUserDbRef;
    FirebaseAuth firebaseAuth;
    public static final String UserDataTag = "User Data";
    private String userId;        //Firebase authentication ID for the current logged in user

    public DatabaseReference open(Activity mainActivity) {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myUserDbRef = database.getReference(UserDataTag);
        //set the user id for the current logged in user
        userId = getUserId(mainActivity);
        return myUserDbRef;
    }

    /*
    * method closes database
     */
    public void close() {

    }

    /*
    * method updates what user is logged in and logged out
     */
    public void updateUser(String userId){
        this.userId = userId;
        Log.d("CSS3334","UserFirebaseData - updateUser - User="+userId);
    }

    //get the current logged in user's id from Firebase
    private String getUserId(Activity activity){
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user == null){
//            //user is signed out
//            Log.d("CSS3334","onAuthStateChanged - User NOT signed in");
//            Intent signInIntent = new Intent(activity, LoginActivity.class);
//            activity.startActivity(signInIntent);
            Log.d("CSS3334","UserFirebaseData - getUserId - Null User=");
            return null;
        }
        Log.d("CSS3334","UserFirebaseData - getUserId - User="+user.getUid());
        return user.getUid();
    }


    /*
    * method creates user in database
     */
    public User createUser(String name, String age, String weight, String height, String bloodPressure, String heartRate, String date) {           //Added String rating as a parameter
        // ---- Get a new database key for the vote
        String key = myUserDbRef.child(UserDataTag).push().getKey();
        // ---- set up the user object
        User newUser = new User(key, name, age, weight, height, bloodPressure, heartRate, date);
        // ---- write the vote to Firebase
        myUserDbRef.child("users").child(userId).child(key).setValue(newUser);
        return newUser;
    }



    /*
    * method deletes user from firebase
     */
    public void deleteUser(User user) {
        String key = user.getKey();
        myUserDbRef.child("users").child(userId).child(key).removeValue();
    }


    /*
    * method that pulls all users in the database
     */
    public List<User> getAllUsers(DataSnapshot dataSnapshot) {
        List<User> userList = new ArrayList<User>();
        for (DataSnapshot data : dataSnapshot.child("users").child(userId).getChildren()) {
            Log.d("CIS3334", "=== getAllUsers Info  === " + data.toString());
            User user = data.getValue(User.class);
            userList.add(user);
        }
        return userList;
    }

}