package omar.marsrover;

import com.omar.marsrover.Point;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class PointSpec {
Point point ;
    private final int location = 5;
    private final int maxLocation = 9;



    @Before
    public void  beforePointTest(){
        point = new Point(location,maxLocation);

    }
@Test
public void CreatingNewInstanceEstablishInitialLocationAndMaximumParameters(){
    assertThat(point.getLocation()).isEqualTo(location);
    assertThat(point.getMaxLocation()).isEqualTo(maxLocation);
}
@Test
    public void RetrievingForwardLocationShouldIncrementPointValueByOne(){
        int expected = point.getLocation()+1;
        assertThat(point.getForwardLocation()).isEqualTo(expected);
}
@Test
    public void RetrievingBackwardLocationShouldDecrementThePointValueByOne(){
    int expected = point.getLocation()+1;
    assertThat(point.getForwardLocation()).isEqualTo(expected);
    }
    @Test
    public void RetrievingForwardLocationShouldSetValueToZeroIfMaximumLocationIsExceeded(){
point.setLocation(point.getMaxLocation());
assertThat(point.getForwardLocation()).isZero();
    }


    @Test
    public  void  RetrievingBackwardLocationShouldSetValueToMaximumLocationIfZeroLocationIsExceeded(){
        point.setLocation(0);
        assertThat(point.getBackwardLocation()).isEqualTo(point.getMaxLocation());
    }



}
