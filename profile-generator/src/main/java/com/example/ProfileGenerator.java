package com.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ProfileGenerator {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Random random = new Random();

		for (int i = 0; i < 100; i++) {
			JSONObject profile = new JSONObject();
			profile.put("profile_id", "1234567890");
			profile.put("purchase_total", random.nextInt(100));

			JSONArray products = new JSONArray();
			for (int j = 0; j < random.nextInt(5); j++) {
				JSONObject product = new JSONObject();

				int id = random.nextInt(10000);
				int categoryId = id % 100;
				product.put("id", id);
				product.put("category_id", categoryId);
				products.add(product);
			}
			profile.put("products", products);

			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(UUID.randomUUID() + ".json"));
				out.write(profile.toJSONString());
				out.close();
			} catch (IOException e) {
			}
		}
	}
}
