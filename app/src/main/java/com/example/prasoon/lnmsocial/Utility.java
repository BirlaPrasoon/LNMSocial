package com.example.prasoon.lnmsocial;

import android.util.Log;
import android.widget.ImageView;
import com.example.prasoon.lnmsocial.models.User;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Utility {

    private static ArrayList<User> userList;

    public static ArrayList<User> getData(){
        if(userList != null)
            return userList;
        else
            return new ArrayList<>();
    }

    public static void downloadImage(final String url, final ImageView imageView){
        Picasso.get()
                .load(url)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(imageView);//, new Callback() {
//                    @Override
//                    public void onSuccess() {
//
//                    }
//
//                    @Override
//                    public void onError(Exception e) {
//                        // Try again online if cache failed
//                        Picasso.get()
//                                .load(url)
//                                .placeholder(R.drawable.user1)
//                                .error(R.drawable.user4)
//                                .into(imageView);
//                        Log.e("ProfileFragment:",e.getMessage());
//                    }
//
//                });
    }

    public static void setData(ArrayList<User> usersList){
        userList = usersList;
    }

    public static void initMaps(Map<String, Boolean> Sports, Map<String, Boolean> Clubs, Map<String, Boolean> Interests){

        Sports.put("Badminton",false);
        Sports.put("TableTennis",false);
        Sports.put("Cricket",false);
        Sports.put("Basketball",false);
        Sports.put("LawnTennis",false);
        Sports.put("VolleyBall",false);
        Sports.put("Football",false);
        Sports.put("Kabaddi",false);
        Sports.put("Squash",false);

        Clubs.put("Cybros",false);
        Clubs.put("CSI",false);
        Clubs.put("Insignia",false);
        Clubs.put("ECell",false);
        Clubs.put("CCell",false);
        Clubs.put("Arts",false);
        Clubs.put("Rendition",false);
        Clubs.put("Quizzinga",false);
        Clubs.put("Literary",false);
        Clubs.put("Chess",false);
        Clubs.put("Fashion",false);
        Clubs.put("Innovation",false);

        Interests.put("CP",false);
        Interests.put("AI",false);
        Interests.put("DS",false);
        Interests.put("ML",false);
        Interests.put("WebDev",false);
        Interests.put("IOS",false);
        Interests.put("MobileWeb",false);
        Interests.put("Android",false);
        Interests.put("BlockChain",false);
        Interests.put("ContentWriting",false);
        Interests.put("Literature",false);
        Interests.put("uiux",false);
    }

    public static User getUserFromDocument(DocumentSnapshot d) {

        User user = new User();

        user.setFirstName(Objects.requireNonNull(d.get("first_name")).toString());
        user.setLastname(Objects.requireNonNull(d.get("last_name")).toString());
        user.setRollNumber(Objects.requireNonNull(d.get("roll_number")).toString());
        user.setEmail(Objects.requireNonNull(d.get("email")).toString());

        Object profileImageUrl = d.get("image_Url");
        String imageUrl = "";
        if (profileImageUrl != null)
            imageUrl = profileImageUrl.toString();
        user.setImageUrl(imageUrl);

        user.setUsername(Objects.requireNonNull(d.get("username")).toString());
        user.setHometown(Objects.requireNonNull(d.get("hometown")).toString());
        user.setState(Objects.requireNonNull(d.get("state")).toString());
        user.setPhoneNumber(Objects.requireNonNull(d.get("phone_number")).toString());
//        user.setPassword(Objects.requireNonNull(d.get("password")).toString());
        Object aboutMeOb = d.get("aboutMe");
        String aboutMe = "";
        if (aboutMeOb != null)
            aboutMe = aboutMeOb.toString();
        user.setAboutMe(aboutMe);
        user.setDepartment(Objects.requireNonNull(d.get("department")).toString());
        user.setYear(Objects.requireNonNull(d.get("year")).toString());

        // Department
        user.setCCE(d.getBoolean("CCE"));
        user.setCSE(d.getBoolean("CSE"));
        user.setECE(d.getBoolean("ECE"));
        user.setME(d.getBoolean("ME"));
        user.setMME(d.getBoolean("MME"));
        // CLUBS
        user.setCybros(d.getBoolean("Cybros"));
        user.setCSI(d.getBoolean("CSI"));
        user.setInsignia(d.getBoolean("Insignia"));
        user.setQuizzinga(d.getBoolean("Quizzinga"));
        user.setEcell(d.getBoolean("ECell"));
        user.setCcell(d.getBoolean("CCell"));
        user.setArts(d.getBoolean("Arts"));
        user.setRendition(d.getBoolean("Rendition"));
        user.setLiterary(d.getBoolean("Literary"));
        user.setChess(d.getBoolean("Chess"));
        user.setFashion(d.getBoolean("Fashion"));
        user.setInnovation(d.getBoolean("Innovation"));

        // Sports
        user.setBadminton(d.getBoolean("Badminton"));
        user.setTableTennis(d.getBoolean("TableTennis"));
        user.setCricket(d.getBoolean("Cricket"));
        user.setFootball(d.getBoolean("Football"));
        user.setBasketball(d.getBoolean("Basketball"));
        user.setVolleyball(d.getBoolean("VolleyBall"));
        user.setLawnTennis(d.getBoolean("LawnTennis"));
        user.setKabaddi(d.getBoolean("Kabaddi"));
        user.setSquash(d.getBoolean("Squash"));

        // Interests
        user.setCP(d.getBoolean("CP"));
        user.setAI(d.getBoolean("AI"));
        user.setML(d.getBoolean("ML"));
        user.setDS(d.getBoolean("DS"));
        user.setWebDev(d.getBoolean("WebDev"));
        user.setMobileWebDev(d.getBoolean("MobileWeb"));
        user.setAndroid(d.getBoolean("Android"));
        user.setIos(d.getBoolean("IOS"));
        user.setBlockChain(d.getBoolean("BlockChain"));
        user.setContentWriting(d.getBoolean("ContentWriting"));
        user.setUiux(d.getBoolean("uiux"));
        user.setLiterature(d.getBoolean("Literature"));

        // Profiles
        user.setFacebookProfileLink(d.getString("facebookLink"));
        user.setLinkedInProfileLink(d.getString("linkedInLink"));
        user.setGithubProfileLink(d.getString("githubLink"));
        user.setTwitterProfileLink(d.getString("twitterLink"));

        return user;
    }
}

