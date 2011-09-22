package adget.android.servicehelper;

import java.util.List;

import adget.android.servicehelper.to.Advertisement;
import adget.android.servicehelper.to.Location;

public interface LocationService {

	public Location getLocation();
	public List<Advertisement> getSurroundingAdvertisements(Location location);
}
