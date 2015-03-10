package com.tyutyutyu.pocketjavaclient.communication.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LowercaseEnumTypeAdapterFactory implements TypeAdapterFactory {

	@Override
	public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

		@SuppressWarnings("unchecked")
		final Class<T> rawType = (Class<T>) type.getRawType();
		if (!rawType.isEnum()) {
			return null;
		}

		final Map<String, T> lowercaseToConstant = new HashMap<>();
		for (final T constant : rawType.getEnumConstants()) {
			lowercaseToConstant.put(toLowercase(constant), constant);
		}

		return new TypeAdapter<T>() {
			@Override
			public void write(JsonWriter out, T value) throws IOException {

				if (value == null) {
					out.nullValue();
				} else {
					out.value(toLowercase(value));
				}
			}

			@Override
			public T read(JsonReader reader) throws IOException {

				if (reader.peek() == JsonToken.NULL) {
					reader.nextNull();
					return null;
				} else {
					return lowercaseToConstant.get(reader.nextString());
				}
			}
		};
	}

	private static String toLowercase(Object o) {

		return o.toString().toLowerCase();
	}

}
