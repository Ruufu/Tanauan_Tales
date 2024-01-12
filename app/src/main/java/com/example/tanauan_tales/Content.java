package com.example.tanauan_tales;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class Content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        // Retrieve information from Intent extras
        int cardNumber = getIntent().getIntExtra("Count", 0);
        displayContent(cardNumber);

        TextView locLink = findViewById(R.id.loc_link);
        ImageView backBtn = findViewById(R.id.back_btn);

        locLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogleMaps(locationLink);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(homeIntent);
                finish();
            }
        });
    }

    public String locationLink;

    private void displayContent(int cardNumber) {
        ImageView locPic = findViewById(R.id.picImg);
        TextView locName = findViewById(R.id.loc_name);
        TextView locLink = findViewById(R.id.loc_link);
        TextView descriptionTxt = findViewById(R.id.descriptionTxt);

        switch (cardNumber) {
            case 1:
                locPic.setImageResource(R.drawable.picture1);
                locName.setText("Kanluran Cafe");
                locLink.setText("Banjo West, Tanauan, Batangas");
                locationLink = "https://www.google.com/maps/place/kan•lu•ran+café/@14.0506053,121.1273773,17.67z/data=!4m6!3m5!1s0x33bd6f8d07353461:0xe2d43d0c0a6a5c22!8m2!3d14.0507014!4d121.1277572!16s%2Fg%2F11txd7swxz?entry=ttu";
                descriptionTxt.setText("Kanluran Cafe stands as a local establishment, likely a charming café, contributing to the social and culinary landscape of Tanauan. With a focus on creating a welcoming atmosphere, this café is an inviting space for residents and visitors alike to gather, savor refreshments, and potentially explore local delicacies. Whether it's a cozy nook for enjoying a cup of coffee or a spot for casual meetings, Kanluran Cafe likely provides a glimpse into the community's daily life. \n");
                break;
            case 2:
                locPic.setImageResource(R.drawable.picture2);
                locName.setText("The Vineyard");
                locLink.setText("Barangay Gonzales, Tanauan, Batangas");
                locationLink = "https://www.google.com/maps/place/The+Vineyard+at+Tanauan/@14.0763003,121.0675226,17z/data=!3m1!4b1!4m9!3m8!1s0x33bd71f24933da6d:0x7169a9a5acc8abc0!5m2!4m1!1i2!8m2!3d14.0763003!4d121.0701029!16s%2Fg%2F11mv4_24th?entry=ttu";
                descriptionTxt.setText("The Vineyard in Tanauan, is a resort for families or groups looking to celebrate or spend quality time with each other. It offers beautiful views, relaxation places, and thrilling adventures and they assure that their guests will feel comfortable, have privacy, and enjoy the magnificent scenery and spaciousness during their stay. \n");
                break;
            case 3:
                locPic.setImageResource(R.drawable.picture3);
                locName.setText("Plaza, Mabini");
                locLink.setText("203 Mabini Ave, Tanauan, Batangas");
                locationLink = "https://www.google.com/maps/place/Old+Municipal+Hall+of+Tanauan+%2F+Plaza+Mabini/@14.0847842,121.1503842,17z/data=!3m1!4b1!4m6!3m5!1s0x33bd6f5ea71c3dc1:0x45f22624b9b21f0!8m2!3d14.0847842!4d121.1529645!16s%2Fg%2F1xtd_2x1?entry=ttu";
                descriptionTxt.setText("It serves as a central public square or plaza within Tanauan, named in honor of Apolinario Mabini. Plazas like these are not just physical spaces; they hold cultural significance and often become focal points for community activities, celebrations, and gatherings. The plaza may feature statues or monuments dedicated to Mabini, enhancing its historical and cultural importance. It likely serves as a place for residents to come together, fostering a sense of community and providing a backdrop for various events and festivities.");
                break;
            case 4:
                locPic.setImageResource(R.drawable.picture4);
                locName.setText("Bañadero, Baywalk");
                locLink.setText("Bañadero, Tanauan, Batangas");
                locationLink = "https://www.google.com/maps/place/Bañadero+Baywalk/@14.0829907,121.057325,17z/data=!3m1!4b1!4m6!3m5!1s0x33bd714cf0c9bc23:0x81ed3f214582f75c!8m2!3d14.0829907!4d121.0621905!16s%2Fg%2F11lm1xt7zt?entry=ttu";
                descriptionTxt.setText("It is a picturesque waterfront area along the shores of Taal Lake, offering a serene escape for both locals and tourists. The location provides a panoramic view of Taal Volcano, creating a tranquil ambiance that invites visitors to relax and enjoy the natural beauty of the surroundings. This baywalk is not merely a scenic spot; it's a vibrant hub with waterfront restaurants, allowing visitors to indulge in local cuisine while taking in the breathtaking views. The ambiance, complemented by the gentle breeze from the lake, makes it a popular destination for leisurely strolls and peaceful moments.");
                break;
            case 5:
                locPic.setImageResource(R.drawable.picture5);
                locName.setText("Apolinario Mabini Shrine");
                locLink.setText("Mabini Ave, Tanauan, Batangas");
                locationLink = "https://www.google.com/maps/place/Apolinario+Mabini+Shrine/@14.1012765,121.0970278,17z/data=!3m1!4b1!4m6!3m5!1s0x33bd655e583d7d4b:0xa6b4dfef2da0e206!8m2!3d14.1012765!4d121.0996081!16s%2Fg%2F1tgf9xb0?entry=ttu";
                descriptionTxt.setText("The Mabini Shrine, nestled in Barangay Talaga, Tanauan, is a significant historical site dedicated to Apolinario Mabini, a prominent Filipino revolutionary leader and political philosopher. Born in this vicinity, Mabini played a crucial role in the Philippine Revolution against Spanish colonization.\n" +
                        " The shrine is strategically located near the ancestral house where Mabini was born. It serves as a repository of artifacts, documents, and memorabilia that chronicle the life and contributions of Mabini to the nation's quest for independence. Visitors can explore exhibits that provide insights into Mabini's intellectual prowess and his unwavering commitment to Philippine sovereignty.");
                break;
            case 6:
                locPic.setImageResource(R.drawable.picture6);
                locName.setText("Jose P Laurel Ancestral House");
                locLink.setText("P Gonzales St, Tanauan, Batangas");
                locationLink = "https://www.google.com/maps/place/Pres.+Jose+P.+Laurel+Memorial+Shrine/@14.0851692,121.1482251,17z/data=!3m1!4b1!4m6!3m5!1s0x33bd6f5dd462cfc9:0x47bab4539519ef9c!8m2!3d14.0851692!4d121.1508054!16s%2Fg%2F1tdmg_w8?entry=ttu";
                descriptionTxt.setText("Born of notable but humble parents, Pres. Jose P. Laurel was born in Tanauan on March 9, 1891. No other Filipino leader has had the honor of serving with distinction in all branches of the government. The late president’s ancestral house was built in 1880 and was restored in 1964. It takes in valued works, furniture’s and personal effects which serve as ancestral bequest of the great statesman and political leader. And because of his influence and love for education, he was able to establish a reputable educational institution. At present, the ancestral house stands proud reminding everyone, tourists and visitors alike, that there stood a man who defend his countrymen.");
                break;
            case 7:
                locPic.setImageResource(R.drawable.picture7);
                locName.setText("Sabang River Eco Park");
                locLink.setText("Banjo West, Tanauan, Batangas");
                locationLink = "https://www.google.com/maps/place/BanjoWest+ecopark+Balete+River/@14.0473049,121.1159863,17z/data=!4m6!3m5!1s0x33bd6e5139773529:0x82ca0aca7f01dd0!8m2!3d14.0473049!4d121.1185666!16s%2Fg%2F11dym5534x?entry=ttu";
                descriptionTxt.setText("Sabang River has twenty one (21) springs located at Brgy. Balele, Brgy. Janopol Occidental, Brgy. Wawa and Brgy Gonzales which flow directly to Taal Lake separating the lakefront of barangays Wawa and Gonzales. The river is a precious source which was primarily used by the locals as part of their everyday living – for drinking, cleaning, washing and household water use.");
                break;
        }
    }

    private void openGoogleMaps(String locationLink) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(locationLink));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(locationLink));
            startActivity(browserIntent);
        }
    }
}