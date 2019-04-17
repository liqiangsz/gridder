package com.sutpc.geo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class GridCreation {
    public static void main(String[] args) {
        double lbCornerLng = Double.parseDouble(args[0]);
        double lbCornerLat = Double.parseDouble(args[1]);
        double rtCornerLng = Double.parseDouble(args[2]);
        double rtCornerLat = Double.parseDouble(args[3]);
        int sizeInMeter = Integer.parseInt(args[4]);
        String outputFile = args[5];

        List<String> outlines = new ArrayList<>();
        for (double x = lbCornerLng; x <= rtCornerLng; x = x + (double)sizeInMeter/Gridder.multiplier){
            for (double y = lbCornerLat; y <= rtCornerLat; y = y + (double)sizeInMeter/Gridder.multiplier){
                Coord coord = new Coord(x, y);
                Coord center = Gridder.getCenter(coord, sizeInMeter);
                String gridId = Gridder.getGridId(coord, sizeInMeter);

                outlines.add(String.format("%s,%.6f,%.6f", gridId, center.lng, center.lat));
            }
        }

        Charset charset = Charset.forName("UTF-8");
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile), charset, StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.CREATE)) {
            for (String line : outlines){
                writer.write(line + "\n");
            }

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

    }
}
