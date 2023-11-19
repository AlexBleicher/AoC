package AoC2022.Day13;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class Packet {

    List<Object> items = new ArrayList<>();

    public Packet(String line) {
        JsonElement json = JsonParser.parseString(line);
        items = parsePackets(json.getAsJsonArray());
    }

    private List<Object> parsePackets(JsonArray elements) {
        List<Object> resultList = new ArrayList<>();
        for (JsonElement jsonElement : elements) {
            if (jsonElement.isJsonArray()) {
                resultList.add(parsePackets(jsonElement.getAsJsonArray()));
            } else {
                resultList.add(jsonElement.getAsInt());
            }
        }
        return resultList;
    }
}