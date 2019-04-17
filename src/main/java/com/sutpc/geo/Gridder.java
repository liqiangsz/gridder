package com.sutpc.geo;


public class Gridder {
    public static int multiplier =  100000;

    //基于左下角坐标生成id
    public static String getGridId(Coord coord, int sizeInMeter){
        long cornerX = (int)(coord.lng * multiplier/sizeInMeter) * sizeInMeter;
        long cornerY = (int)(coord.lat * multiplier/sizeInMeter) * sizeInMeter;

        return String.format("%d_%d", cornerX, cornerY);
    }

    public static Coord getCenter(String gridId, int sizeInMeter){
        String[] flds = gridId.split("_");
        long cornerX = Integer.parseInt(flds[0]);
        long cornerY = Integer.parseInt(flds[1]);

        return new Coord((cornerX + 0.5*sizeInMeter)/multiplier, (cornerY + 0.5*sizeInMeter)/multiplier);
    }

    public static Coord getCenter(Coord coord, int sizeInMeter){
        long cornerX = (int)(coord.lng * multiplier/sizeInMeter) * sizeInMeter;
        long cornerY = (int)(coord.lat * multiplier/sizeInMeter) * sizeInMeter;

        return new Coord((cornerX + 0.5*sizeInMeter)/multiplier, (cornerY + 0.5*sizeInMeter)/multiplier);
    }


}
