package com.suninfo.emm.myfirstandroidapp.Fruit;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.suninfo.emm.myfirstandroidapp.R;

import java.util.ArrayList;
import java.util.List;

public class FruitActivity extends Activity {

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(FruitActivity.this,
                R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_fruit_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(FruitActivity.this, fruit.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
        fruitList.add(apple);
        Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
        fruitList.add(banana);
        Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
        fruitList.add(orange);
        Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
        fruitList.add(watermelon);
        Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
        fruitList.add(pear);
        Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
        fruitList.add(grape);
        Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
        fruitList.add(pineapple);
        Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
        fruitList.add(strawberry);
        Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
        fruitList.add(cherry);
        Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
        fruitList.add(mango);

        Fruit apple1 = new Fruit("Apple", R.drawable.apple_pic);
        fruitList.add(apple1);
        Fruit banana1 = new Fruit("Banana", R.drawable.banana_pic);
        fruitList.add(banana1);
        Fruit orange1 = new Fruit("Orange", R.drawable.orange_pic);
        fruitList.add(orange1);
        Fruit watermelon1 = new Fruit("Watermelon", R.drawable.watermelon_pic);
        fruitList.add(watermelon1);
        Fruit pear1 = new Fruit("Pear", R.drawable.pear_pic);
        fruitList.add(pear1);
        Fruit grape1 = new Fruit("Grape", R.drawable.grape_pic);
        fruitList.add(grape1);
        Fruit pineapple1 = new Fruit("Pineapple", R.drawable.pineapple_pic);
        fruitList.add(pineapple1);
        Fruit strawberry1 = new Fruit("Strawberry", R.drawable.strawberry_pic);
        fruitList.add(strawberry1);
        Fruit cherry1 = new Fruit("Cherry", R.drawable.cherry_pic);
        fruitList.add(cherry1);
        Fruit mango1 = new Fruit("Mango", R.drawable.mango_pic);
        fruitList.add(mango1);
    }

}
