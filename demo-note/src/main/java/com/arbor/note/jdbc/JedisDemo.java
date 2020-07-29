package com.arbor.note.jdbc;

/**
 * com.arbor.note.jdbc.JedisDemo
 *
 * @author Joem
 * @date 2020-07-22
 * @since v2.0.0
 */
public class JedisDemo {

    static String key_prefix = "zadd zset_";
    static String key_prefix_String = "set set_";

    public static void main(String[] args) {
        long begin = 1174720135415484418L;
        int nums = 400;
        System.out.print(key_prefix_String + nums + "_key ");
        for (int i = 0; i < nums; i++) {
            long tmp = begin + i * 3;
//            System.out.print(tmp + "852601058848769aaaaaaaaaaaaa ");
            System.out.print(tmp + " ");
        }

        String value = "1144852601058848769aaaaaaaaaaaaa 1145852601058848769aaaaaaaaaaaaa " +
                "1146852601058848769aaaaaaaaaaaaa 1147852601058848769aaaaaaaaaaaaa 1148852601058848769aaaaaaaaaaaaa " +
                "1149852601058848769aaaaaaaaaaaaa 1150852601058848769aaaaaaaaaaaaa 1151852601058848769aaaaaaaaaaaaa " +
                "1152852601058848769aaaaaaaaaaaaa 1153852601058848769aaaaaaaaaaaaa 1154852601058848769aaaaaaaaaaaaa " +
                "1155852601058848769aaaaaaaaaaaaa 1156852601058848769aaaaaaaaaaaaa 1157852601058848769aaaaaaaaaaaaa " +
                "1158852601058848769aaaaaaaaaaaaa 1159852601058848769aaaaaaaaaaaaa 1160852601058848769aaaaaaaaaaaaa " +
                "1161852601058848769aaaaaaaaaaaaa 1162852601058848769aaaaaaaaaaaaa 1163852601058848769aaaaaaaaaaaaa " +
                "1164852601058848769aaaaaaaaaaaaa 1165852601058848769aaaaaaaaaaaaa 1166852601058848769aaaaaaaaaaaaa " +
                "1167852601058848769aaaaaaaaaaaaa 1168852601058848769aaaaaaaaaaaaa 1169852601058848769aaaaaaaaaaaaa " +
                "1170852601058848769aaaaaaaaaaaaa 1171852601058848769aaaaaaaaaaaaa 1172852601058848769aaaaaaaaaaaaa " +
                "1173852601058848769aaaaaaaaaaaaa 1174852601058848769aaaaaaaaaaaaa 1175852601058848769aaaaaaaaaaaaa " +
                "1176852601058848769aaaaaaaaaaaaa 1177852601058848769aaaaaaaaaaaaa 1178852601058848769aaaaaaaaaaaaa " +
                "1179852601058848769aaaaaaaaaaaaa 1180852601058848769aaaaaaaaaaaaa 1181852601058848769aaaaaaaaaaaaa " +
                "1182852601058848769aaaaaaaaaaaaa 1183852601058848769aaaaaaaaaaaaa 1184852601058848769aaaaaaaaaaaaa " +
                "1185852601058848769aaaaaaaaaaaaa 1186852601058848769aaaaaaaaaaaaa 1187852601058848769aaaaaaaaaaaaa " +
                "1188852601058848769aaaaaaaaaaaaa 1189852601058848769aaaaaaaaaaaaa 1190852601058848769aaaaaaaaaaaaa " +
                "1191852601058848769aaaaaaaaaaaaa 1192852601058848769aaaaaaaaaaaaa 1193852601058848769aaaaaaaaaaaaa " +
                "1194852601058848769aaaaaaaaaaaaa 1195852601058848769aaaaaaaaaaaaa 1196852601058848769aaaaaaaaaaaaa " +
                "1197852601058848769aaaaaaaaaaaaa 1198852601058848769aaaaaaaaaaaaa 1199852601058848769aaaaaaaaaaaaa " +
                "1200852601058848769aaaaaaaaaaaaa 1201852601058848769aaaaaaaaaaaaa 1202852601058848769aaaaaaaaaaaaa " +
                "1203852601058848769aaaaaaaaaaaaa 1204852601058848769aaaaaaaaaaaaa 1205852601058848769aaaaaaaaaaaaa " +
                "1206852601058848769aaaaaaaaaaaaa 1207852601058848769aaaaaaaaaaaaa 1208852601058848769aaaaaaaaaaaaa " +
                "1209852601058848769aaaaaaaaaaaaa 1210852601058848769aaaaaaaaaaaaa 1211852601058848769aaaaaaaaaaaaa " +
                "1212852601058848769aaaaaaaaaaaaa 1213852601058848769aaaaaaaaaaaaa 1214852601058848769aaaaaaaaaaaaa " +
                "1215852601058848769aaaaaaaaaaaaa 1216852601058848769aaaaaaaaaaaaa 1217852601058848769aaaaaaaaaaaaa " +
                "1218852601058848769aaaaaaaaaaaaa 1219852601058848769aaaaaaaaaaaaa 1220852601058848769aaaaaaaaaaaaa " +
                "1221852601058848769aaaaaaaaaaaaa 1222852601058848769aaaaaaaaaaaaa 1223852601058848769aaaaaaaaaaaaa " +
                "1224852601058848769aaaaaaaaaaaaa 1225852601058848769aaaaaaaaaaaaa 1226852601058848769aaaaaaaaaaaaa " +
                "1227852601058848769aaaaaaaaaaaaa 1228852601058848769aaaaaaaaaaaaa 1229852601058848769aaaaaaaaaaaaa " +
                "1230852601058848769aaaaaaaaaaaaa 1231852601058848769aaaaaaaaaaaaa 1232852601058848769aaaaaaaaaaaaa " +
                "1233852601058848769aaaaaaaaaaaaa 1234852601058848769aaaaaaaaaaaaa 1235852601058848769aaaaaaaaaaaaa " +
                "1236852601058848769aaaaaaaaaaaaa 1237852601058848769aaaaaaaaaaaaa 1238852601058848769aaaaaaaaaaaaa " +
                "1239852601058848769aaaaaaaaaaaaa 1240852601058848769aaaaaaaaaaaaa 1241852601058848769aaaaaaaaaaaaa " +
                "1242852601058848769aaaaaaaaaaaaa 1243852601058848769aaaaaaaaaaaaa 1244852601058848769aaaaaaaaaaaaa " +
                "1245852601058848769aaaaaaaaaaaaa 1246852601058848769aaaaaaaaaaaaa 1247852601058848769aaaaaaaaaaaaa " +
                "1248852601058848769aaaaaaaaaaaaa 1249852601058848769aaaaaaaaaaaaa 1250852601058848769aaaaaaaaaaaaa " +
                "1251852601058848769aaaaaaaaaaaaa 1252852601058848769aaaaaaaaaaaaa 1253852601058848769aaaaaaaaaaaaa " +
                "1254852601058848769aaaaaaaaaaaaa 1255852601058848769aaaaaaaaaaaaa 1256852601058848769aaaaaaaaaaaaa " +
                "1257852601058848769aaaaaaaaaaaaa 1258852601058848769aaaaaaaaaaaaa 1259852601058848769aaaaaaaaaaaaa " +
                "1260852601058848769aaaaaaaaaaaaa 1261852601058848769aaaaaaaaaaaaa 1262852601058848769aaaaaaaaaaaaa " +
                "1263852601058848769aaaaaaaaaaaaa 1264852601058848769aaaaaaaaaaaaa 1265852601058848769aaaaaaaaaaaaa " +
                "1266852601058848769aaaaaaaaaaaaa 1267852601058848769aaaaaaaaaaaaa 1268852601058848769aaaaaaaaaaaaa " +
                "1269852601058848769aaaaaaaaaaaaa 1270852601058848769aaaaaaaaaaaaa 1271852601058848769aaaaaaaaaaaaa " +
                "1272852601058848769aaaaaaaaaaaaa 1273852601058848769aaaaaaaaaaaaa 1274852601058848769aaaaaaaaaaaaa " +
                "1275852601058848769aaaaaaaaaaaaa 1276852601058848769aaaaaaaaaaaaa 1277852601058848769aaaaaaaaaaaaa " +
                "1278852601058848769aaaaaaaaaaaaa 1279852601058848769aaaaaaaaaaaaa 1280852601058848769aaaaaaaaaaaaa " +
                "1281852601058848769aaaaaaaaaaaaa 1282852601058848769aaaaaaaaaaaaa 1283852601058848769aaaaaaaaaaaaa " +
                "1284852601058848769aaaaaaaaaaaaa 1285852601058848769aaaaaaaaaaaaa 1286852601058848769aaaaaaaaaaaaa " +
                "1287852601058848769aaaaaaaaaaaaa 1288852601058848769aaaaaaaaaaaaa 1289852601058848769aaaaaaaaaaaaa " +
                "1290852601058848769aaaaaaaaaaaaa 1291852601058848769aaaaaaaaaaaaa 1292852601058848769aaaaaaaaaaaaa " +
                "1293852601058848769aaaaaaaaaaaaa 1294852601058848769aaaaaaaaaaaaa 1295852601058848769aaaaaaaaaaaaa " +
                "1296852601058848769aaaaaaaaaaaaa 1297852601058848769aaaaaaaaaaaaa 1298852601058848769aaaaaaaaaaaaa " +
                "1299852601058848769aaaaaaaaaaaaa 1300852601058848769aaaaaaaaaaaaa 1301852601058848769aaaaaaaaaaaaa " +
                "1302852601058848769aaaaaaaaaaaaa 1303852601058848769aaaaaaaaaaaaa 1304852601058848769aaaaaaaaaaaaa " +
                "1305852601058848769aaaaaaaaaaaaa 1306852601058848769aaaaaaaaaaaaa 1307852601058848769aaaaaaaaaaaaa " +
                "1308852601058848769aaaaaaaaaaaaa 1309852601058848769aaaaaaaaaaaaa 1310852601058848769aaaaaaaaaaaaa " +
                "1311852601058848769aaaaaaaaaaaaa 1312852601058848769aaaaaaaaaaaaa 1313852601058848769aaaaaaaaaaaaa " +
                "1314852601058848769aaaaaaaaaaaaa 1315852601058848769aaaaaaaaaaaaa 1316852601058848769aaaaaaaaaaaaa " +
                "1317852601058848769aaaaaaaaaaaaa 1318852601058848769aaaaaaaaaaaaa 1319852601058848769aaaaaaaaaaaaa " +
                "1320852601058848769aaaaaaaaaaaaa 1321852601058848769aaaaaaaaaaaaa 1322852601058848769aaaaaaaaaaaaa " +
                "1323852601058848769aaaaaaaaaaaaa 1324852601058848769aaaaaaaaaaaaa 1325852601058848769aaaaaaaaaaaaa " +
                "1326852601058848769aaaaaaaaaaaaa 1327852601058848769aaaaaaaaaaaaa 1328852601058848769aaaaaaaaaaaaa " +
                "1329852601058848769aaaaaaaaaaaaa 1330852601058848769aaaaaaaaaaaaa 1331852601058848769aaaaaaaaaaaaa " +
                "1332852601058848769aaaaaaaaaaaaa 1333852601058848769aaaaaaaaaaaaa 1334852601058848769aaaaaaaaaaaaa " +
                "1335852601058848769aaaaaaaaaaaaa 1336852601058848769aaaaaaaaaaaaa 1337852601058848769aaaaaaaaaaaaa " +
                "1338852601058848769aaaaaaaaaaaaa 1339852601058848769aaaaaaaaaaaaa 1340852601058848769aaaaaaaaaaaaa " +
                "1341852601058848769aaaaaaaaaaaaa 1342852601058848769aaaaaaaaaaaaa 1343852601058848769aaaaaaaaaaaaa " +
                "1344852601058848769aaaaaaaaaaaaa 1345852601058848769aaaaaaaaaaaaa 1346852601058848769aaaaaaaaaaaaa " +
                "1347852601058848769aaaaaaaaaaaaa 1348852601058848769aaaaaaaaaaaaa 1349852601058848769aaaaaaaaaaaaa " +
                "1350852601058848769aaaaaaaaaaaaa 1351852601058848769aaaaaaaaaaaaa 1352852601058848769aaaaaaaaaaaaa " +
                "1353852601058848769aaaaaaaaaaaaa 1354852601058848769aaaaaaaaaaaaa 1355852601058848769aaaaaaaaaaaaa " +
                "1356852601058848769aaaaaaaaaaaaa 1357852601058848769aaaaaaaaaaaaa 1358852601058848769aaaaaaaaaaaaa " +
                "1359852601058848769aaaaaaaaaaaaa 1360852601058848769aaaaaaaaaaaaa 1361852601058848769aaaaaaaaaaaaa " +
                "1362852601058848769aaaaaaaaaaaaa 1363852601058848769aaaaaaaaaaaaa 1364852601058848769aaaaaaaaaaaaa " +
                "1365852601058848769aaaaaaaaaaaaa 1366852601058848769aaaaaaaaaaaaa 1367852601058848769aaaaaaaaaaaaa " +
                "1368852601058848769aaaaaaaaaaaaa 1369852601058848769aaaaaaaaaaaaa 1370852601058848769aaaaaaaaaaaaa " +
                "1371852601058848769aaaaaaaaaaaaa 1372852601058848769aaaaaaaaaaaaa 1373852601058848769aaaaaaaaaaaaa " +
                "1374852601058848769aaaaaaaaaaaaa 1375852601058848769aaaaaaaaaaaaa 1376852601058848769aaaaaaaaaaaaa " +
                "1377852601058848769aaaaaaaaaaaaa 1378852601058848769aaaaaaaaaaaaa 1379852601058848769aaaaaaaaaaaaa " +
                "1380852601058848769aaaaaaaaaaaaa 1381852601058848769aaaaaaaaaaaaa 1382852601058848769aaaaaaaaaaaaa " +
                "1383852601058848769aaaaaaaaaaaaa 1384852601058848769aaaaaaaaaaaaa 1385852601058848769aaaaaaaaaaaaa " +
                "1386852601058848769aaaaaaaaaaaaa 1387852601058848769aaaaaaaaaaaaa 1388852601058848769aaaaaaaaaaaaa " +
                "1389852601058848769aaaaaaaaaaaaa 1390852601058848769aaaaaaaaaaaaa 1391852601058848769aaaaaaaaaaaaa " +
                "1392852601058848769aaaaaaaaaaaaa 1393852601058848769aaaaaaaaaaaaa 1394852601058848769aaaaaaaaaaaaa " +
                "1395852601058848769aaaaaaaaaaaaa 1396852601058848769aaaaaaaaaaaaa 1397852601058848769aaaaaaaaaaaaa " +
                "1398852601058848769aaaaaaaaaaaaa 1399852601058848769aaaaaaaaaaaaa 1400852601058848769aaaaaaaaaaaaa " +
                "1401852601058848769aaaaaaaaaaaaa 1402852601058848769aaaaaaaaaaaaa 1403852601058848769aaaaaaaaaaaaa " +
                "1404852601058848769aaaaaaaaaaaaa 1405852601058848769aaaaaaaaaaaaa 1406852601058848769aaaaaaaaaaaaa " +
                "1407852601058848769aaaaaaaaaaaaa 1408852601058848769aaaaaaaaaaaaa 1409852601058848769aaaaaaaaaaaaa " +
                "1410852601058848769aaaaaaaaaaaaa 1411852601058848769aaaaaaaaaaaaa 1412852601058848769aaaaaaaaaaaaa " +
                "1413852601058848769aaaaaaaaaaaaa 1414852601058848769aaaaaaaaaaaaa 1415852601058848769aaaaaaaaaaaaa " +
                "1416852601058848769aaaaaaaaaaaaa 1417852601058848769aaaaaaaaaaaaa 1418852601058848769aaaaaaaaaaaaa " +
                "1419852601058848769aaaaaaaaaaaaa 1420852601058848769aaaaaaaaaaaaa 1421852601058848769aaaaaaaaaaaaa " +
                "1422852601058848769aaaaaaaaaaaaa 1423852601058848769aaaaaaaaaaaaa 1424852601058848769aaaaaaaaaaaaa " +
                "1425852601058848769aaaaaaaaaaaaa 1426852601058848769aaaaaaaaaaaaa 1427852601058848769aaaaaaaaaaaaa " +
                "1428852601058848769aaaaaaaaaaaaa 1429852601058848769aaaaaaaaaaaaa 1430852601058848769aaaaaaaaaaaaa " +
                "1431852601058848769aaaaaaaaaaaaa 1432852601058848769aaaaaaaaaaaaa 1433852601058848769aaaaaaaaaaaaa " +
                "1434852601058848769aaaaaaaaaaaaa 1435852601058848769aaaaaaaaaaaaa 1436852601058848769aaaaaaaaaaaaa " +
                "1437852601058848769aaaaaaaaaaaaa 1438852601058848769aaaaaaaaaaaaa 1439852601058848769aaaaaaaaaaaaa " +
                "1440852601058848769aaaaaaaaaaaaa 1441852601058848769aaaaaaaaaaaaa 1442852601058848769aaaaaaaaaaaaa " +
                "1443852601058848769aaaaaaaaaaaaa 1444852601058848769aaaaaaaaaaaaa 1445852601058848769aaaaaaaaaaaaa " +
                "1446852601058848769aaaaaaaaaaaaa 1447852601058848769aaaaaaaaaaaaa 1448852601058848769aaaaaaaaaaaaa " +
                "1449852601058848769aaaaaaaaaaaaa 1450852601058848769aaaaaaaaaaaaa 1451852601058848769aaaaaaaaaaaaa " +
                "1452852601058848769aaaaaaaaaaaaa 1453852601058848769aaaaaaaaaaaaa 1454852601058848769aaaaaaaaaaaaa " +
                "1455852601058848769aaaaaaaaaaaaa 1456852601058848769aaaaaaaaaaaaa 1457852601058848769aaaaaaaaaaaaa " +
                "1458852601058848769aaaaaaaaaaaaa 1459852601058848769aaaaaaaaaaaaa 1460852601058848769aaaaaaaaaaaaa " +
                "1461852601058848769aaaaaaaaaaaaa 1462852601058848769aaaaaaaaaaaaa 1463852601058848769aaaaaaaaaaaaa " +
                "1464852601058848769aaaaaaaaaaaaa 1465852601058848769aaaaaaaaaaaaa 1466852601058848769aaaaaaaaaaaaa " +
                "1467852601058848769aaaaaaaaaaaaa 1468852601058848769aaaaaaaaaaaaa 1469852601058848769aaaaaaaaaaaaa " +
                "1470852601058848769aaaaaaaaaaaaa 1471852601058848769aaaaaaaaaaaaa 1472852601058848769aaaaaaaaaaaaa " +
                "1473852601058848769aaaaaaaaaaaaa 1474852601058848769aaaaaaaaaaaaa 1475852601058848769aaaaaaaaaaaaa " +
                "1476852601058848769aaaaaaaaaaaaa 1477852601058848769aaaaaaaaaaaaa 1478852601058848769aaaaaaaaaaaaa " +
                "1479852601058848769aaaaaaaaaaaaa 1480852601058848769aaaaaaaaaaaaa 1481852601058848769aaaaaaaaaaaaa " +
                "1482852601058848769aaaaaaaaaaaaa 1483852601058848769aaaaaaaaaaaaa 1484852601058848769aaaaaaaaaaaaa " +
                "1485852601058848769aaaaaaaaaaaaa 1486852601058848769aaaaaaaaaaaaa 1487852601058848769aaaaaaaaaaaaa " +
                "1488852601058848769aaaaaaaaaaaaa 1489852601058848769aaaaaaaaaaaaa 1490852601058848769aaaaaaaaaaaaa " +
                "1491852601058848769aaaaaaaaaaaaa 1492852601058848769aaaaaaaaaaaaa 1493852601058848769aaaaaaaaaaaaa " +
                "1494852601058848769aaaaaaaaaaaaa 1495852601058848769aaaaaaaaaaaaa 1496852601058848769aaaaaaaaaaaaa " +
                "1497852601058848769aaaaaaaaaaaaa 1498852601058848769aaaaaaaaaaaaa 1499852601058848769aaaaaaaaaaaaa " +
                "1500852601058848769aaaaaaaaaaaaa 1501852601058848769aaaaaaaaaaaaa 1502852601058848769aaaaaaaaaaaaa " +
                "1503852601058848769aaaaaaaaaaaaa 1504852601058848769aaaaaaaaaaaaa 1505852601058848769aaaaaaaaaaaaa " +
                "1506852601058848769aaaaaaaaaaaaa 1507852601058848769aaaaaaaaaaaaa 1508852601058848769aaaaaaaaaaaaa " +
                "1509852601058848769aaaaaaaaaaaaa 1510852601058848769aaaaaaaaaaaaa 1511852601058848769aaaaaaaaaaaaa " +
                "1512852601058848769aaaaaaaaaaaaa 1513852601058848769aaaaaaaaaaaaa 1514852601058848769aaaaaaaaaaaaa " +
                "1515852601058848769aaaaaaaaaaaaa 1516852601058848769aaaaaaaaaaaaa 1517852601058848769aaaaaaaaaaaaa " +
                "1518852601058848769aaaaaaaaaaaaa 1519852601058848769aaaaaaaaaaaaa 1520852601058848769aaaaaaaaaaaaa " +
                "1521852601058848769aaaaaaaaaaaaa 1522852601058848769aaaaaaaaaaaaa 1523852601058848769aaaaaaaaaaaaa " +
                "1524852601058848769aaaaaaaaaaaaa 1525852601058848769aaaaaaaaaaaaa 1526852601058848769aaaaaaaaaaaaa " +
                "1527852601058848769aaaaaaaaaaaaa 1528852601058848769aaaaaaaaaaaaa 1529852601058848769aaaaaaaaaaaaa " +
                "1530852601058848769aaaaaaaaaaaaa 1531852601058848769aaaaaaaaaaaaa 1532852601058848769aaaaaaaaaaaaa " +
                "1533852601058848769aaaaaaaaaaaaa 1534852601058848769aaaaaaaaaaaaa 1535852601058848769aaaaaaaaaaaaa " +
                "1536852601058848769aaaaaaaaaaaaa 1537852601058848769aaaaaaaaaaaaa 1538852601058848769aaaaaaaaaaaaa " +
                "1539852601058848769aaaaaaaaaaaaa 1540852601058848769aaaaaaaaaaaaa 1541852601058848769aaaaaaaaaaaaa " +
                "1542852601058848769aaaaaaaaaaaaa 1543852601058848769aaaaaaaaaaaaa";
        byte[] bytes = value.getBytes();
//        Jedis jedis = new Jedis("127.0.0.1", 6379, true);

//        String set = jedisShardInfo1.set("set_400_key".getBytes(), bytes);

//        ShardedJedis jedis = pool.getResource();
        String keys = "myname";

//        Object vaule = jedis.sadd("sadd_400_key", value);
//        System.out.println(vaule);
//        System.out.println(set);

    }

//    private static ShardedJedisPool pool;
//    static {
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxTotal(100);
//        config.setMaxIdle(50);
//        config.setMaxWaitMillis(3000);
//        config.setTestOnBorrow(true);
//        config.setTestOnReturn(true);
//        // 集群
//        JedisShardInfo jedisShardInfo1 = new JedisShardInfo("127.0.0.1", 6379);
//        jedisShardInfo1.setPassword("123456");
//        List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
//        list.add(jedisShardInfo1);
//        pool = new ShardedJedisPool(config, list);
////        　　　　 pool = new ShardedJedisPool(config, list);
//    }

}
