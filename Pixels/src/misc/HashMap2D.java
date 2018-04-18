package misc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HashMap2D<K1, K2, V> {
	
	HashMap<K1, HashMap<K2, V>> map;
	
	public HashMap2D() {
		map = new HashMap<K1, HashMap<K2, V>>();
		//List<V>[][] arr = new List<V>[10][10];
	}
	
	private void createColumn(K1 row) {
		map.put(row, new HashMap<K2, V>());
	}
	
	public V get(K1 key1, K2 key2) {
		V value = null;
		if (columnExists(key1)) {
			if (map.get(key1).get(key2) != null) {
				value = map.get(key1).get(key2);
			} else {
				System.err.println("Value does not exist");
			}
		} else {
			createColumn(key1);
			get(key1, key2);
		}
		return value;
	}
	
	
	public void put(K1 key1, K2 key2, V value) {
		if (!columnExists(key1)) {
			createColumn(key1);
		}
		map.get(key1).put(key2, value);
	}
	
	public V remove(K1 key1, K2 key2) {
		if (valueExists(key1, key2)) {
			V val = map.get(key1).remove(key2);
			return val;
		} else {
			return null;
		}
	}
	
	public boolean columnExists(K1 key1) {
		return map.get(key1) != null;
	}
	
	public boolean valueExists(K1 key1, K2 key2) {
		if (columnExists(key1)) {
			return map.get(key1).get(key2) != null;
		} else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		return map.isEmpty();
	}
	
	public boolean isColumnEmpty(K1 key1) {
		if (columnExists(key1)) {
			return map.get(key1).isEmpty();
		} else {
			return true;
		}
	}
	
	public int rowSize() {
		return map.size();
	}
	
	public int columnSize(K1 key1) {
		if (columnExists(key1)) {
			return map.get(key1).size();
		} else {
			return 0;
		}
	}
	//TODO include number of rows in total entry?
	//no, this counts the number of values in the map
	public int totalSize() {
		int total = 0;
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<K1, HashMap<K2, V>> entry = (Map.Entry<K1, HashMap<K2, V>>) it.next();
			System.out.println(entry.getValue());
			total += entry.getValue().size();
		}
		return total;
	}
	
	
	public void saveMap() {
		String location  = System.getProperty("user.dir") + "/save";
		new File(location).mkdir();
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<K1, HashMap<K2, V>> entry = (Map.Entry<K1, HashMap<K2, V>>) it.next();
			new File(location + "/" + entry.getKey()).mkdir();
			//File f = new File(location + "/" + entry.getKey() + "/" + entry.getValue() + ".txt");
			saveCols(entry.getValue(), location + "/" + entry.getKey() + "/");
		}
	}
	
	private void saveCols(HashMap<K2, V> col, String location) {
		Iterator it = col.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<K2, V> entry = (Map.Entry<K2, V>) it.next();
			File f = new File(location + entry.getKey() + ".txt");
			try {
				PrintStream out = new PrintStream(f);
				//f.createNewFile();
				out.println(entry.getValue());
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean unload(K1 key1, K2 key2) {
		return false;
	}
}
