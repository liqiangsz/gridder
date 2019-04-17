package test.com.sutpc.geo; 

import com.sutpc.geo.Coord;
import com.sutpc.geo.Gridder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GridderTest { 

@Test
public void testGetGridId() throws Exception { 
    Coord coord = new Coord(134.256895, 25.456852);

    String gridId = Gridder.getGridId(coord, 500);
    assertEquals("Check grid id getter", "13425500_2545500", gridId);

    gridId = Gridder.getGridId(coord, 100);
    assertEquals("Check grid id getter", "13425600_2545600", gridId);

} 


@Test
public void testGetCenterForGridIdSizeInMeter() throws Exception {
    Coord coord = Gridder.getCenter("13425500_2545500", 500);
    assertEquals(134.25750, coord.lng, 0.0);
    assertEquals(25.45750, coord.lat, 0.0);

    coord = Gridder.getCenter("13425600_2545600", 100);
    assertEquals(134.25650, coord.lng, 0.0);
    assertEquals(25.45650, coord.lat, 0.0);

} 


@Test
public void testGetCenterForCoordSizeInMeter() throws Exception {
    Coord coord = new Coord(134.256895, 25.456852);
    Coord center = Gridder.getCenter(coord, 500);

    assertEquals(134.25750, center.lng, 0.0);
    assertEquals(25.45750, center.lat, 0.0);

    center = Gridder.getCenter(coord, 100);

    assertEquals(134.25650, center.lng, 0.0);
    assertEquals(25.45650, center.lat, 0.0);

} 


} 
