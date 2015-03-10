package com.tyutyutyu.pocketjavaclient.communication.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class BooleanAdapter implements JsonSerializer<Boolean>, JsonDeserializer<Boolean> {

	@Override
	public JsonElement serialize(Boolean booleanValue, Type type, JsonSerializationContext jsonSerializationContext) {

		return new JsonPrimitive(booleanValue ? "1" : "0");
	}

	@Override
	public Boolean deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

		return jsonElement.getAsString().equals("1");
	}
}
