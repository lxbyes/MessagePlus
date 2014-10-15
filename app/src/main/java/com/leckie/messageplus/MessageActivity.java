package com.leckie.messageplus;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 短信息显示<br>
 *
 * @author Leckie
 * @version  2014-10-15
 */
public class MessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        ListView lv = (ListView) findViewById(R.id.lv);

        List<Map<String, Object>> listItem = new ArrayList<Map<String, Object>>();
        // 生成数据并放入List
        for(int i=0; i<12; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("itemImage", R.drawable.ic_launcher);
            item.put("itemTitle", "message");
            item.put("itemText", "生成适配器的Item和动态数组对应的元素 ");
            listItem.add(item);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItem, R.layout.lv_item,
                new String[]{"itemImage", "itemTitle", "itemText"},
                new int[]{R.id.item_image, R.id.item_title, R.id.item_title});

        lv.setAdapter(simpleAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setTitle("onItemClick-->position：" + position + " id:" + id);
            }
        });

        lv.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.setHeaderTitle("长按菜单-ContextMenu");
                menu.add(0, 0, 0, "弹出长按菜单0");
                menu.add(0, 1, 0, "弹出长按菜单1");
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                setTitle("onItemLongClick-->position：" + position + " id:" + id);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        setTitle("点击了长按菜单里面的第"+item.getItemId()+"个项目");

        return super.onOptionsItemSelected(item);
    }
}
