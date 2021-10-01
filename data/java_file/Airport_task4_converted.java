IMPORT PLANES.EXPERIMENTALPLANE; 
IMPORT MODELS.MILITARYTYPE; 
IMPORT PLANES.MILITARYPLANE; 
IMPORT PLANES.PASSENGERPLANE; 
IMPORT PLANES.PLANE; 
 
IMPORT JAVA.UTIL.*; 
 
// VERSION: 1.1 
// MADE by VITALI SHULHA 
// 4-JAN-2019 
 
PUBLIC CLASS AIRPORT { 
 PRIVATE LIST<? EXTENDS PLANE> PLANES; 
 
 
 
 PUBLIC LIST<PASSENGERPLANE> GETPASPL() { 
 LIST<? EXTENDS PLANE> l = THIS.PLANES; 
 LIST<PASSENGERPLANE> x = NEW ARRAYLIST<>(); 
 FOR (PLANE p : l) {if (p INSTANCEOF PASSENGERPLANE) {X.ADD((PASSENGERPLANE) p);}} 
 RETURN x; 
 } 
 
 PUBLIC LIST<MILITARYPLANE> GETMILITARYPLANES() { 
 LIST<MILITARYPLANE> MILITARYPLANES = NEW ARRAYLIST<>(); 
 FOR (PLANE PLANE : PLANES) { 
 if (PLANE INSTANCEOF MILITARYPLANE) { 
 MILITARYPLANES.ADD((MILITARYPLANE) PLANE); 
 } //if 
 ELSE { 
 
 } // ELSE 
 } //FOR 
 RETURN MILITARYPLANES; 
 } 
 
 PUBLIC PASSENGERPLANE GETPASSENGERPLANEWITHMAXPASSENGERSCAPACITY() { 
 LIST<PASSENGERPLANE> PASSENGERPLANES = GETPASPL(); 
 PASSENGERPLANE PLANEWITHMAXCAPACITY = PASSENGERPLANES.GET(0); 
 FOR (INT i = 0; i < PASSENGERPLANES.SIZE(); i++) { 
 if (PASSENGERPLANES.GET(I).GETPASSENGERSCAPACITY() > PLANEWITHMAXCAPACITY.GETPASSENGERSCAPACITY()) { 
 PLANEWITHMAXCAPACITY = PASSENGERPLANES.GET(I); 
 } 
 } 
 
 
 
 
 
 
 RETURN PLANEWITHMAXCAPACITY; 
 } 
 
 PUBLIC LIST<MILITARYPLANE> GETTRANSPORTMILITARYPLANES() { 
 LIST<MILITARYPLANE> TRANSPORTMILITARYPLANES = NEW ARRAYLIST<>(); 
 LIST<MILITARYPLANE> MILITARYPLANES = GETMILITARYPLANES(); 
 FOR (INT i = 0; i < MILITARYPLANES.SIZE(); i++) { 
 MILITARYPLANE PLANE = MILITARYPLANES.GET(I); 
 if (PLANE.GETTYPE() == MILITARYTYPE.TRANSPORT) { 
 TRANSPORTMILITARYPLANES.ADD(PLANE); 
 } 
 } 
 RETURN TRANSPORTMILITARYPLANES; 
 } 
 
 PUBLIC LIST<MILITARYPLANE> GETBOMBERMILITARYPLANES() { 
 LIST<MILITARYPLANE> BOMBERMILITARYPLANES = NEW ARRAYLIST<>(); 
 LIST<MILITARYPLANE> MILITARYPLANES = GETMILITARYPLANES(); 
 FOR (INT i = 0; i < MILITARYPLANES.SIZE(); i++) { 
 MILITARYPLANE PLANE = MILITARYPLANES.GET(I); 
 if (PLANE.GETTYPE() == MILITARYTYPE.BOMBER) { 
 BOMBERMILITARYPLANES.ADD(PLANE); 
 } 
 } 
 RETURN BOMBERMILITARYPLANES; 
 
 } 
 
 PUBLIC LIST<EXPERIMENTALPLANE> GETEXPERIMENTALPLANES() { 
 LIST<EXPERIMENTALPLANE> EXPERIMENTALPLANES = NEW ARRAYLIST<>(); 
 FOR (PLANE PLANE : PLANES) { 
 if (PLANE INSTANCEOF EXPERIMENTALPLANE) { 
 EXPERIMENTALPLANES.ADD((EXPERIMENTALPLANE) PLANE); 
 } 
 } 
 RETURN EXPERIMENTALPLANES; 
 } 
 
 PUBLIC AIRPORT SORTBYMAXDISTANCE() { 
 COLLECTIONS.SORT(PLANES, NEW COMPARATOR<PLANE>() { 
 PUBLIC INT COMPARE(PLANE o1, PLANE o2) { 
 RETURN O1.GET_MAX_FLIGHT_DISTANCE() - O2.GET_MAX_FLIGHT_DISTANCE(); 
 } 
 }); 
 RETURN THIS; 
 } 
 
 
 /** 
 * SORTS by MAX SPEED 
 * @RETURN AIRPORT 
 */ 
 PUBLIC AIRPORT SORTBYMAXSPEED() { 
 COLLECTIONS.SORT(PLANES, NEW COMPARATOR<PLANE>() { 
 PUBLIC INT COMPARE(PLANE o1, PLANE o2) { 
 RETURN O1.GETMS() - O2.GETMS(); 
 } 
 }); 
 RETURN THIS; 
 } 
 
 PUBLIC AIRPORT SORTBYMAXLOADCAPACITY() { 
 COLLECTIONS.SORT(PLANES, NEW COMPARATOR<PLANE>() { 
 PUBLIC INT COMPARE(PLANE o1, PLANE o2) { 
 RETURN O1.GETMINLOADCAPACITY() - O2.GETMINLOADCAPACITY(); 
 } 
 }); 
 RETURN THIS; 
 } 
 
 PUBLIC LIST<? EXTENDS PLANE> GETPLANES() { 
 RETURN PLANES; 
 } 
 
 PRIVATE VOID PRINT(COLLECTION<? EXTENDS PLANE> COLLECTION) { 
 ITERATOR<? EXTENDS PLANE> ITERATOR = COLLECTION.ITERATOR(); 
 WHILE (ITERATOR.HASNEXT()) { 
 PLANE PLANE = ITERATOR.NEXT(); 
 SYSTEM.OUT.PRINTLN(PLANE); 
 } 
 } 
 
 @OVERRIDE 
 PUBLIC STRING TOSTRING() { 
 RETURN "AIRPORT{" + 
 "PLANES=" + PLANES.TOSTRING() + 
 '}'; 
 } 
 
 //CONSTRUCTOR 
 PUBLIC AIRPORT(LIST<? EXTENDS PLANE> PLANES) { 
 THIS.PLANES = PLANES; 
 } 
 
} 
