import java.util.ArrayList;

public class 嵌入式算法 {
    class Beacon
    {
        int id;      //beacon's unique ID
        int rssi;    //RSSI value from the beacon
        Beacon (int i, int r)
        {
            id = i;
            rssi = r;
        }
    }
    class Position
    {
        int x;
        int y;
        Position(int a, int b)
        {
            x = a;
            y = b;
        }
    }

    Beacon beacons1 = new Beacon(101,1050);
    Beacon beacons2 = new Beacon(111,820);
    Beacon beacons3 = new Beacon(102,100);
    Beacon beacons4 = new Beacon(100,620);
    Beacon[] Beacons_1 = {beacons1,beacons2,beacons3,beacons4};

    Beacon beacons5 = new Beacon(101,860);
    Beacon beacons6 = new Beacon(111,630);
    Beacon beacons7 = new Beacon(102,310);
    Beacon beacons8 = new Beacon(100,680);
    Beacon[] Beacons_2 = {beacons5,beacons6,beacons7,beacons8};

    public int[][] beacon_info = {
            {3, 0, 100},
            {3, 3, 101},
            {6, 0, 102},
            {9, 5, 109},
            {0, 5, 110},
            {6, 3, 111}
    };

    public static void main(String[] args){
        嵌入式算法 qianrushi1 = new 嵌入式算法();
        qianrushi1.calcPositionUpdate(qianrushi1.Beacons_1, 4);
//        qianrushi1.calcPositionUpdate(qianrushi1.Beacons_2, 4);
    }

    public Beacon[] createBeaconArray(int assiOf101, int assiOf111,int assiOf102, int assiOf100){
        Beacon beacons1 = new Beacon(101,assiOf101);
        Beacon beacons2 = new Beacon(111,assiOf111);
        Beacon beacons3 = new Beacon(102,assiOf102);
        Beacon beacons4 = new Beacon(100,assiOf100);
        Beacon[] Beacons = {beacons1,beacons2,beacons3,beacons4};
        return Beacons;
    }

    public  void calcPositionUpdate(Beacon[] received_beacon, int received_beacon_num)
    {
        if (received_beacon_num > 0)    //check if there are beacon signals received
        {
            ArrayList<float[]> possiblePosition = new ArrayList<float[]>();
            float minDifference = 99999.9f;
            int XOfMinDifference = 0;
            int YOfMinDifference = 0;

            Position the_1st_beacon_position = new Position(0, 0);
            Position the_2nd_beacon_position = new Position(0, 0);
            Position the_3rd_beacon_position = new Position(0, 0);

            float the_1st_beacon_distance = 0.0f;
            float the_2nd_beacon_distance = 0.0f;
            float the_3rd_beacon_distance = 0.0f;
            Beacon[] beacon = received_beacon;

            //sort all the beacon by signal rssi
            for (int i = 0; i < beacon.length - 1; i++)
            {
                int num = i;

                for(int j = i+1; j < beacon.length; j++){
                    num = beacon[num].rssi > beacon[j].rssi ? j : num;
                }
                changePosition(beacon,i,num);
            }

            //we get the 1st beacon, 2nd beacon, 3rd beacon positon
            if (beacon.length>=2)
            {
                the_1st_beacon_position = get_beacon_position(beacon[0].id);
                the_1st_beacon_distance = beacon[0].rssi;
                the_2nd_beacon_position = get_beacon_position(beacon[1].id);
                the_2nd_beacon_distance = beacon[1].rssi;
                the_3rd_beacon_position = get_beacon_position(beacon[2].id);
                the_3rd_beacon_distance = beacon[2].rssi;
            }

            //find the possible position of locator that meet the 1st, 2nd, 3rd beacon rssi
            if (beacon.length>=2)
            {
                for(int i=0; i<10;i++){
                    for(int j=0; j<6; j++){
                        if(calculateDistanceWithBeacon(the_1st_beacon_position.x, the_1st_beacon_position.y,i,j) < the_1st_beacon_distance
                                && calculateDistanceWithBeacon(the_2nd_beacon_position.x, the_2nd_beacon_position.y,i,j) < the_2nd_beacon_distance){
                            float tempDistance = calculateDistanceWithBeacon(the_3rd_beacon_position.x, the_3rd_beacon_position.y,i,j);
                            float differenceOfDistance = Math.abs(tempDistance-the_3rd_beacon_distance);
                            float[] temp = {i,j,differenceOfDistance};
                            possiblePosition.add(temp);
                        }
                    }
                }

                for(int i=0; i<possiblePosition.size(); i++){
                    if(minDifference > possiblePosition.get(i)[2]){
                        minDifference = possiblePosition.get(i)[2];
                        XOfMinDifference = (int) possiblePosition.get(i)[0];
                        YOfMinDifference = (int) possiblePosition.get(i)[1];
                    }
                }

                updateLocator(XOfMinDifference, YOfMinDifference, the_1st_beacon_distance);
            }
        }
    }

    public void changePosition(Beacon[] beacon, int origin, int min){
        int temp_0 = beacon[origin].id;
        int temp_1 = beacon[origin].rssi;
        beacon[origin].id = beacon[min].id;
        beacon[origin].rssi = beacon[min].rssi;
        beacon[min].id = temp_0;
        beacon[min].rssi = temp_1;
    }

    public float calculateDistanceWithBeacon(int x_of_beacon, int y_of_beacon, int x, int y){
        float distance = (float) Math.sqrt(Math.pow((x-x_of_beacon)*200,2)+Math.pow((y-y_of_beacon)*300,2));
        return distance;
    }

    public Position get_beacon_position(int id)
    {
        Position pos = new Position(0, 0);
        for (int i = 0; i < beacon_info.length; i++)
        {
            if (beacon_info[i][2] == id)
            {
                pos.x = beacon_info[i][0];
                pos.y = beacon_info[i][1];
            }
        }
        return pos;
    }

    public float rssiToDistance(int rssi)
    {
        int rssi_at_1m = -10;  //  should change
        int n = 4;

        float distance = (float) Math.pow(10, (rssi_at_1m - rssi) / (10*n));
        return distance;
    }

    public void updateLocator(int i, int j ,float range){
        System.out.println(i+" "+j+" "+range);
    }
}
