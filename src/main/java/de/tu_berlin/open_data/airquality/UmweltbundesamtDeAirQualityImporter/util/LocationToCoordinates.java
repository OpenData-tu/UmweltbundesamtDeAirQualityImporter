package de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.util;


import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.model.Location;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rohullah on 05.07.17.
 */
public class LocationToCoordinates {

    public static final Map<String, Location> locationNamesToCoordinates;

    static {
        HashMap<String, Location> locationDictionary = new HashMap<>();

        locationDictionary.put("DEBB007", new Location(51.462734,13.526796));
        locationDictionary.put("DEBB021", new Location(52.401352,13.059945));
        locationDictionary.put("DEBB029", new Location(53.064259,14.285139));
        locationDictionary.put("DEBB032", new Location(52.146267,14.638166));
        locationDictionary.put("DEBB044", new Location(51.756474,14.327997));
        locationDictionary.put("DEBB045", new Location(52.337336,14.538595));
        locationDictionary.put("DEBB048", new Location(52.931889,12.809481));
        locationDictionary.put("DEBB049", new Location(52.409309,12.548375));
        locationDictionary.put("DEBB053", new Location(52.563835,14.015253));
        locationDictionary.put("DEBB054", new Location(52.393932,13.037476));
        locationDictionary.put("DEBB055", new Location(52.420444,12.552303));
        locationDictionary.put("DEBB060", new Location(52.832466,13.822211));
        locationDictionary.put("DEBB063", new Location(52.998749,11.738460));
        locationDictionary.put("DEBB064", new Location(51.746344,14.334550));
        locationDictionary.put("DEBB065", new Location(52.194225,12.561389));
        locationDictionary.put("DEBB066", new Location(51.897598,14.057064));
        locationDictionary.put("DEBB067", new Location(52.608608,12.885195));
        locationDictionary.put("DEBB068", new Location(52.677650,13.582269));
        locationDictionary.put("DEBB073", new Location(52.388869,13.094616));
        locationDictionary.put("DEBB075", new Location(52.484165,13.123697));
        locationDictionary.put("DEBB083", new Location(51.564499,14.376400));
        locationDictionary.put("DEBB086", new Location(52.349703,13.424304));
        locationDictionary.put("DEBE010", new Location(52.542744,13.349119));
        locationDictionary.put("DEBE032", new Location(52.473091,13.225856));
        locationDictionary.put("DEBE034", new Location(52.488091,13.434014));
        locationDictionary.put("DEBE051", new Location(52.636708,13.494857));
        locationDictionary.put("DEBE056", new Location(52.447750,13.647013));
        locationDictionary.put("DEBE061", new Location(52.463593,13.318308));
        locationDictionary.put("DEBE063", new Location(52.467491,13.441809));
        locationDictionary.put("DEBE064", new Location(52.481808,13.433661));
        locationDictionary.put("DEBE065", new Location(52.513319,13.469314));
        locationDictionary.put("DEBE068", new Location(52.513603,13.418831));
        locationDictionary.put("DEBE069", new Location(52.438210,13.387636));
        locationDictionary.put("DEBW004", new Location(49.082428,8.403838));
        locationDictionary.put("DEBW005", new Location(49.543999,8.465963));
        locationDictionary.put("DEBW009", new Location(49.419575,8.676808));
        locationDictionary.put("DEBW010", new Location(49.300678,8.699930));
        locationDictionary.put("DEBW013", new Location(48.808800,9.229745));
        locationDictionary.put("DEBW015", new Location(49.165480,9.224880));
        locationDictionary.put("DEBW019", new Location(48.396819,9.979058));
        locationDictionary.put("DEBW022", new Location(48.576871,7.802327));
        locationDictionary.put("DEBW023", new Location(47.588152,7.633272));
        locationDictionary.put("DEBW024", new Location(48.899272,9.172880));
        locationDictionary.put("DEBW027", new Location(48.488888,9.207319));
        locationDictionary.put("DEBW029", new Location(48.850372,10.098308));
        locationDictionary.put("DEBW031", new Location(47.808469,7.764350));
        locationDictionary.put("DEBW033", new Location(48.889030,8.665574));
        locationDictionary.put("DEBW038", new Location(47.660553,9.486256));
        locationDictionary.put("DEBW039", new Location(48.048420,8.463820));
        locationDictionary.put("DEBW042", new Location(48.678188,9.227586));
        locationDictionary.put("DEBW046", new Location(48.090185,9.799714));
        locationDictionary.put("DEBW052", new Location(47.664429,9.169281));
        locationDictionary.put("DEBW056", new Location(49.107254,9.733632));
        locationDictionary.put("DEBW059", new Location(49.634841,9.657919));
        locationDictionary.put("DEBW073", new Location(47.819182,7.567796));
        locationDictionary.put("DEBW076", new Location(48.773254,8.219627));
        locationDictionary.put("DEBW081", new Location(49.028711,8.355600));
        locationDictionary.put("DEBW084", new Location(48.001507,7.831786));
        locationDictionary.put("DEBW087", new Location(48.345402,9.207747));
        locationDictionary.put("DEBW107", new Location(48.507319,9.050407));
        locationDictionary.put("DEBW112", new Location(48.648926,8.903302));
        locationDictionary.put("DEBY001", new Location(49.304890,10.572297));
        locationDictionary.put("DEBY006", new Location(48.364586,10.895028));
        locationDictionary.put("DEBY007", new Location(48.376572,10.888370));
        locationDictionary.put("DEBY009", new Location(49.898331,10.887686));
        locationDictionary.put("DEBY012", new Location(48.177177,12.829314));
        locationDictionary.put("DEBY021", new Location(48.769196,11.428767));
        locationDictionary.put("DEBY028", new Location(48.909519,11.879245));
        locationDictionary.put("DEBY032", new Location(50.103135,11.442591));
        locationDictionary.put("DEBY033", new Location(48.539799,12.157049));
        locationDictionary.put("DEBY035", new Location(47.554391,9.690021));
        locationDictionary.put("DEBY037", new Location(48.137252,11.564925));
        locationDictionary.put("DEBY039", new Location(48.154533,11.554669));
        locationDictionary.put("DEBY052", new Location(48.397079,10.008291));
        locationDictionary.put("DEBY056", new Location(49.472210,10.984706));
        locationDictionary.put("DEBY063", new Location(49.019013,12.101856));
        locationDictionary.put("DEBY068", new Location(50.048397,10.232075));
        locationDictionary.put("DEBY072", new Location(49.438465,12.548870));
        locationDictionary.put("DEBY077", new Location(49.804695,9.956419));
        locationDictionary.put("DEBY088", new Location(48.021660,12.538174));
        locationDictionary.put("DEBY089", new Location(48.173194,11.648036));
        locationDictionary.put("DEBY093", new Location(49.487983,11.786342));
        locationDictionary.put("DEBY099", new Location(48.326013,10.903049));
        locationDictionary.put("DEBY109", new Location(47.968754,11.220172));
        locationDictionary.put("DEBY110", new Location(48.370371,10.896822));
        locationDictionary.put("DEBY111", new Location(49.943638,11.570088));
        locationDictionary.put("DEBY115", new Location(48.149609,11.536513));
        locationDictionary.put("DEBY118", new Location(48.573627,13.422039));
        locationDictionary.put("DEBY119", new Location(49.790524,9.947653));
        locationDictionary.put("DEBY120", new Location(49.440479,11.036098));
        locationDictionary.put("DEBY121", new Location(47.648460,12.188325));
        locationDictionary.put("DEBY122", new Location(47.518013,10.404232));
        locationDictionary.put("DEHB001", new Location(53.088081,8.810041));
        locationDictionary.put("DEHB002", new Location(53.060043,8.916966));
        locationDictionary.put("DEHB004", new Location(53.180946,8.625456));
        locationDictionary.put("DEHB005", new Location(53.562455,8.569406));
        locationDictionary.put("DEHB006", new Location(53.078663,8.825172));
        locationDictionary.put("DEHB011", new Location(53.585258,8.598761));
        locationDictionary.put("DEHB012", new Location(53.124561,8.735047));
        locationDictionary.put("DEHB013", new Location(53.117700,8.695060));
        locationDictionary.put("DEHE001", new Location(49.872299,8.664619));
        locationDictionary.put("DEHE005", new Location(50.101871,8.542052));
        locationDictionary.put("DEHE008", new Location(50.125332,8.746342));
        locationDictionary.put("DEHE011", new Location(50.134842,8.918083));
        locationDictionary.put("DEHE013", new Location(51.314247,9.483397));
        locationDictionary.put("DEHE018", new Location(50.010325,8.451527));
        locationDictionary.put("DEHE020", new Location(50.567185,8.500619));
        locationDictionary.put("DEHE022", new Location(50.050343,8.244950));
        locationDictionary.put("DEHE024", new Location(51.291757,9.774589));
        locationDictionary.put("DEHE028", new Location(49.653465,8.817250));
        locationDictionary.put("DEHE030", new Location(50.804258,8.769324));
        locationDictionary.put("DEHE032", new Location(50.970024,9.800261));
        locationDictionary.put("DEHE037", new Location(50.077191,8.230316));
        locationDictionary.put("DEHE040", new Location(49.869457,8.653744));
        locationDictionary.put("DEHE041", new Location(50.124588,8.691911));
        locationDictionary.put("DEHE043", new Location(49.825161,8.516797));
        locationDictionary.put("DEHE044", new Location(50.383213,8.060997));
        locationDictionary.put("DEHE045", new Location(49.672507,9.001981));
        locationDictionary.put("DEHE046", new Location(51.430897,8.928171));
        locationDictionary.put("DEHE049", new Location(51.312073,9.491120));
        locationDictionary.put("DEHE050", new Location(51.360755,9.271233));
        locationDictionary.put("DEHE051", new Location(50.497711,9.935862));
        locationDictionary.put("DEHE052", new Location(50.221943,8.446078));
        locationDictionary.put("DEHE059", new Location(50.550026,9.684853));
        locationDictionary.put("DEHE060", new Location(51.154842,9.031753));
        locationDictionary.put("DEHE061", new Location(50.584108,8.668578));
        locationDictionary.put("DEHE062", new Location(50.807014,8.769397));
        locationDictionary.put("DEHE063", new Location(49.643238,8.642000));
        locationDictionary.put("DEHH008", new Location(53.564137,9.967882));
        locationDictionary.put("DEHH015", new Location(53.523262,10.021227));
        locationDictionary.put("DEHH016", new Location(53.529018,10.081685));
        locationDictionary.put("DEHH026", new Location(53.560632,9.957236));
        locationDictionary.put("DEHH033", new Location(53.638291,9.998009));
        locationDictionary.put("DEHH059", new Location(53.507930,9.990569));
        locationDictionary.put("DEHH068", new Location(53.592300,10.053859));
        locationDictionary.put("DEHH070", new Location(53.555664,9.943011));
        locationDictionary.put("DEHH072", new Location(53.535958,9.844080));
        locationDictionary.put("DEMV003", new Location(53.559784,13.266440));
        locationDictionary.put("DEMV004", new Location(53.817775,12.064708));
        locationDictionary.put("DEMV007", new Location(54.161555,12.174105));
        locationDictionary.put("DEMV012", new Location(53.520456,14.257407));
        locationDictionary.put("DEMV017", new Location(53.302352,11.362965));
        locationDictionary.put("DEMV019", new Location(53.781750,12.175512));
        locationDictionary.put("DEMV020", new Location(54.092278,12.141994));
        locationDictionary.put("DEMV021", new Location(54.171330,12.080003));
        locationDictionary.put("DEMV022", new Location(54.092617,12.099552));
        locationDictionary.put("DEMV023", new Location(53.631805,11.398332));
        locationDictionary.put("DEMV024", new Location(53.396348,12.463929));
        locationDictionary.put("DENI011", new Location(52.226940,10.473640));
        locationDictionary.put("DENI016", new Location(51.901580,10.481320));
        locationDictionary.put("DENI020", new Location(52.440810,10.816380));
        locationDictionary.put("DENI028", new Location(51.507580,10.238540));
        locationDictionary.put("DENI029", new Location(53.362350,7.207260));
        locationDictionary.put("DENI031", new Location(53.596170,8.090590));
        locationDictionary.put("DENI038", new Location(52.255340,8.052860));
        locationDictionary.put("DENI041", new Location(52.181030,9.066870));
        locationDictionary.put("DENI042", new Location(51.551070,9.949760));
        locationDictionary.put("DENI043", new Location(52.498550,7.317470));
        locationDictionary.put("DENI048", new Location(52.359500,9.715770));
        locationDictionary.put("DENI051", new Location(51.758160,10.612480));
        locationDictionary.put("DENI052", new Location(52.829430,9.622950));
        locationDictionary.put("DENI053", new Location(52.997960,7.942570));
        locationDictionary.put("DENI054", new Location(52.362920,9.706120));
        locationDictionary.put("DENI058", new Location(53.715300,7.213980));
        locationDictionary.put("DENI059", new Location(53.830170,8.801220));
        locationDictionary.put("DENI060", new Location(52.957020,11.167050));
        locationDictionary.put("DENI062", new Location(53.246960,10.456500));
        locationDictionary.put("DENI063", new Location(53.524180,9.685030));
        locationDictionary.put("DENI067", new Location(52.270300,8.041470));
        locationDictionary.put("DENI068", new Location(51.530200,9.928330));
        locationDictionary.put("DENI070", new Location(52.153690,10.455910));
        locationDictionary.put("DENI071", new Location(51.613650,10.422750));
        locationDictionary.put("DENI077", new Location(51.708840,9.554620));
        locationDictionary.put("DENW002", new Location(51.641384,7.331405));
        locationDictionary.put("DENW006", new Location(51.592205,7.569838));
        locationDictionary.put("DENW024", new Location(51.496527,6.981044));
        locationDictionary.put("DENW029", new Location(51.403005,7.208572));
        locationDictionary.put("DENW030", new Location(51.672810,6.629575));
        locationDictionary.put("DENW042", new Location(51.337669,6.640242));
        locationDictionary.put("DENW043", new Location(51.451177,7.030603));
        locationDictionary.put("DENW058", new Location(50.876121,6.873789));
        locationDictionary.put("DENW059", new Location(50.889816,6.985164));
        locationDictionary.put("DENW062", new Location(50.753639,7.082675));
        locationDictionary.put("DENW065", new Location(50.930328,8.191934));
        locationDictionary.put("DENW207", new Location(50.773129,6.095775));
        locationDictionary.put("DENW094", new Location(50.754704,6.093923));
        locationDictionary.put("DEBW029", new Location(48.850372,10.098308));
        locationDictionary.put("DETH011", new Location(50.987758,12.437621));
        locationDictionary.put("DESH001", new Location(53.670571,9.585911));
        locationDictionary.put("DESN001", new Location(50.570872,12.997278));
        locationDictionary.put("DEBY002", new Location(50.058193,12.188650));
        locationDictionary.put("DEBY005", new Location(49.991516,9.117972));
        locationDictionary.put("DEST095", new Location(51.759552,11.449439));
        locationDictionary.put("DEBE062", new Location(52.653149,13.296353));
        locationDictionary.put("DEBE067", new Location(52.506603,13.332839));
        locationDictionary.put("DEBE066", new Location(52.485279,13.529574));
        locationDictionary.put("DEBE027", new Location(52.398521,13.370711));
        locationDictionary.put("DEBE018", new Location(52.486134,13.348416));
        locationDictionary.put("DERP022", new Location(49.842136,7.866208));
        locationDictionary.put("DEBY079", new Location(47.723186,12.858856));
        locationDictionary.put("DESH016", new Location(53.570583,10.214872));
        locationDictionary.put("DESN004", new Location(51.175669,14.443772));
        locationDictionary.put("DEST029", new Location(51.803566,11.738976));
        locationDictionary.put("DESL001", new Location(49.263905,6.687125));
        locationDictionary.put("DESL002", new Location(49.362049,7.263233));
        locationDictionary.put("DENW200", new Location(52.005624,8.552804));
        locationDictionary.put("DENW067", new Location(52.023169,8.548389));
        locationDictionary.put("DESL019", new Location(49.416885,6.552036));
        locationDictionary.put("DEST015", new Location(51.651165,12.302900));
        locationDictionary.put("DENW081", new Location(51.862000,6.874553));
        locationDictionary.put("DESN006", new Location(51.125427,12.494156));
        locationDictionary.put("DESH008", new Location(54.093233,10.240623));
        locationDictionary.put("DENW021", new Location(51.525963,6.976908));
        locationDictionary.put("DENI075", new Location(52.266730,10.540550));
        locationDictionary.put("DESH035", new Location(53.896118,9.156908));
        locationDictionary.put("DEST002", new Location(52.268369,11.864795));
        locationDictionary.put("DEHE039", new Location(50.770382,9.459403));
        locationDictionary.put("DESN049", new Location(50.431322,12.611125));
        locationDictionary.put("DESN083", new Location(50.845737,12.903366));
        locationDictionary.put("DESN011", new Location(50.832461,12.917336));
        locationDictionary.put("DEBY014", new Location(50.260578,10.959311));
        locationDictionary.put("DESN076", new Location(51.303772,13.009405));
        locationDictionary.put("DEST091", new Location(51.840583,12.244763));
        locationDictionary.put("DESL003", new Location(49.357861,6.733539));
        locationDictionary.put("DEST104", new Location(51.837055,11.891655));
        locationDictionary.put("DENW136", new Location(51.523567,7.483597));
        locationDictionary.put("DENW101", new Location(51.519638,7.464347));
        locationDictionary.put("DENW008", new Location(51.536911,7.457464));
        locationDictionary.put("DETH026", new Location(50.561752,10.375299));
        locationDictionary.put("DESN084", new Location(51.026294,13.731607));
        locationDictionary.put("DESN061", new Location(51.064930,13.741397));
        locationDictionary.put("DESN092", new Location(51.036106,13.730206));
        locationDictionary.put("DENW254", new Location(51.467926,6.752535));
        locationDictionary.put("DENW112", new Location(51.437708,6.771800));
        locationDictionary.put("DENW131", new Location(51.506218,6.746859));
        locationDictionary.put("DENW040", new Location(51.385255,6.763000));
        locationDictionary.put("DENW034", new Location(51.524022,6.748402));
        locationDictionary.put("DENW082", new Location(51.213110,6.782564));
        locationDictionary.put("DENW071", new Location(51.249211,6.732383));
        locationDictionary.put("DETH013", new Location(50.978291,10.317236));
        locationDictionary.put("DENW182", new Location(50.927111,6.582203));
        locationDictionary.put("DETH043", new Location(50.984874,11.019353));
        locationDictionary.put("DETH020", new Location(50.979455,11.037926));
        locationDictionary.put("DEBY113", new Location(49.605911,10.963528));
        locationDictionary.put("DENW134", new Location(51.477932,7.005278));
        locationDictionary.put("DENW247", new Location(51.406967,6.965641));
        locationDictionary.put("DESH013", new Location(54.412987,11.215994));
        locationDictionary.put("DESN053", new Location(50.428488,12.953458));
        locationDictionary.put("DESH022", new Location(54.781430,9.438089));
        locationDictionary.put("DEUB046", new Location(48.947502,13.420559));
        locationDictionary.put("DERP026", new Location(49.536026,8.356562));
        locationDictionary.put("DESN017", new Location(50.916302,13.346825));
        locationDictionary.put("DEBW122", new Location(47.988535,7.859872));
        locationDictionary.put("DEHE058", new Location(50.549297,9.682161));
        locationDictionary.put("DENW208", new Location(51.527883,7.084598));
        locationDictionary.put("DENW022", new Location(51.533646,7.101786));
        locationDictionary.put("DETH009", new Location(50.877316,12.074711));
        locationDictionary.put("DESN019", new Location(50.826000,12.542056));
        locationDictionary.put("DETH036", new Location(50.655861,12.205200));
        locationDictionary.put("DENW180", new Location(51.063766,6.559477));
        locationDictionary.put("DESN020", new Location(51.155800,14.973958));
        locationDictionary.put("DENW133", new Location(51.362827,7.463531));
        locationDictionary.put("DEST044", new Location(51.897018,11.057462));
        locationDictionary.put("DEST101", new Location(51.889545,11.055946));
        locationDictionary.put("DEST075", new Location(51.475183,11.983414));
        locationDictionary.put("DEST050", new Location(51.496188,11.979072));
        locationDictionary.put("DEST102", new Location(51.494755,11.981314));
        locationDictionary.put("DEHH074", new Location(53.538528,10.102822));
        locationDictionary.put("DEHH049", new Location(53.568124,9.786234));
        locationDictionary.put("DEHH047", new Location(53.630737,10.110595));
        locationDictionary.put("DEHH073", new Location(53.532074,9.832703));
        locationDictionary.put("DEHH064", new Location(53.564399,9.944580));
        locationDictionary.put("DEHH050", new Location(53.480927,9.857223));
        locationDictionary.put("DEHH021", new Location(53.487669,10.083646));
        locationDictionary.put("DEBW152", new Location(49.146010,9.225861));
        locationDictionary.put("DEBY020", new Location(50.316101,11.904311));
        locationDictionary.put("DETH061", new Location(50.791616,11.661233));
        locationDictionary.put("DERP014", new Location(49.741035,7.193486));
        locationDictionary.put("DESH015", new Location(53.924713,9.532635));
        locationDictionary.put("DESH025", new Location(53.928028,9.511769));
        locationDictionary.put("DETH041", new Location(50.933513,11.597061));
        locationDictionary.put("DERP019", new Location(49.446747,7.768869));
        locationDictionary.put("DEBW080", new Location(49.007930,8.386900));
        locationDictionary.put("DEBY031", new Location(47.725140,10.306561));
        locationDictionary.put("DESH027", new Location(54.304676,10.135159));
        locationDictionary.put("DESH033", new Location(54.309674,10.116564));
        locationDictionary.put("DEBY004", new Location(49.869422,9.171545));
        locationDictionary.put("DESN024", new Location(50.354721,12.468952));
        locationDictionary.put("DERP024", new Location(50.355579,7.596583));
        locationDictionary.put("DERP045", new Location(50.359605,7.592515));
        locationDictionary.put("DENW116", new Location(51.342561,6.670194));
        locationDictionary.put("DENW211", new Location(50.962857,7.004589));
        locationDictionary.put("DENW212", new Location(50.947369,6.957700));
        locationDictionary.put("DENW053", new Location(51.019344,6.884636));
        locationDictionary.put("DESL006", new Location(49.183361,6.744856));
        locationDictionary.put("DESN077", new Location(51.335872,12.334685));
        locationDictionary.put("DESN025", new Location(51.344162,12.377164));
        locationDictionary.put("DESN082", new Location(51.375988,12.425748));
        locationDictionary.put("DESN059", new Location(51.317905,12.297412));
        locationDictionary.put("DEBW120", new Location(48.801583,9.016747));
        locationDictionary.put("DEST090", new Location(51.321381,12.032136));
        locationDictionary.put("DENW079", new Location(51.028877,7.005063));
        locationDictionary.put("DEHE042", new Location(50.532963,8.684398));
        locationDictionary.put("DEBW117", new Location(48.889194,9.189703));
        locationDictionary.put("DERP041", new Location(49.478691,8.443653));
        locationDictionary.put("DERP003", new Location(49.455379,8.425584));
        locationDictionary.put("DERP001", new Location(49.515052,8.402374));
        locationDictionary.put("DESH023", new Location(53.835491,10.695936));
        locationDictionary.put("DEST103", new Location(52.120905,11.632755));
        locationDictionary.put("DEST077", new Location(52.127903,11.611456));
        locationDictionary.put("DERP012", new Location(49.998837,8.268996));
        locationDictionary.put("DERP007", new Location(50.017078,8.216497));
        locationDictionary.put("DERP010", new Location(50.000973,8.261278));
        locationDictionary.put("DERP011", new Location(50.009953,8.265563));
        locationDictionary.put("DERP009", new Location(49.994976,8.273964));
        locationDictionary.put("DEBW098", new Location(49.492546,8.471010));
        locationDictionary.put("DEBW142", new Location(48.902855,9.081558));
        locationDictionary.put("DENW015", new Location(51.698960,7.122714));
        locationDictionary.put("DEBY013", new Location(48.182835,12.781385));
        locationDictionary.put("DENW100", new Location(51.169968,6.458841));
        locationDictionary.put("DENW259", new Location(51.169437,6.439975));
        locationDictionary.put("DENW096", new Location(51.154617,6.425711));
        locationDictionary.put("DETH095", new Location(51.207944,10.450997));
        locationDictionary.put("DETH091", new Location(51.205466,10.448475));
        locationDictionary.put("DENW038", new Location(51.453460,6.865107));
        locationDictionary.put("DENW260", new Location(51.953266,7.619386));
        locationDictionary.put("DENW095", new Location(51.936547,7.611580));
        locationDictionary.put("DEBY047", new Location(50.323242,11.721605));
        locationDictionary.put("DENW066", new Location(51.326942,6.195867));
        locationDictionary.put("DEUB030", new Location(53.141304,13.031661));
        locationDictionary.put("DETH027", new Location(50.499955,11.134591));
        locationDictionary.put("DEBY049", new Location(48.853211,11.777817));
        locationDictionary.put("DERP021", new Location(50.424674,7.481394));
        locationDictionary.put("DERP046", new Location(50.431400,7.460811));
        locationDictionary.put("DENW074", new Location(50.883476,6.469364));
        locationDictionary.put("DESN079", new Location(51.285355,14.749731));
        locationDictionary.put("DESH030", new Location(53.681992,9.997256));
        locationDictionary.put("DETH018", new Location(51.497196,10.791404));
        locationDictionary.put("DEBY053", new Location(49.445910,11.088444));
        locationDictionary.put("DEBY058", new Location(49.462227,11.025472));
        locationDictionary.put("DENW188", new Location(51.474971,6.863657));
        locationDictionary.put("DEBW125", new Location(49.004227,8.524194));
        locationDictionary.put("DERP017", new Location(49.270263,7.826521));
        locationDictionary.put("DESN081", new Location(50.481750,12.130375));
        locationDictionary.put("DESN075", new Location(50.486138,12.138053));
        locationDictionary.put("DETH042", new Location(51.333084,10.867189));
        locationDictionary.put("DESN051", new Location(51.119511,13.675005));
        locationDictionary.put("DENW078", new Location(51.303919,6.819967));
        locationDictionary.put("DESH028", new Location(53.698940,10.775797));
        locationDictionary.put("DEBY062", new Location(48.972401,13.128932));
        locationDictionary.put("DEBW147", new Location(48.489349,9.210744));
        locationDictionary.put("DEBY030", new Location(48.904228,11.948794));
        locationDictionary.put("DETH005", new Location(50.651182,11.368876));
        locationDictionary.put("DESL010", new Location(49.244247,6.948775));
        locationDictionary.put("DESL012", new Location(49.233463,6.987600));
        locationDictionary.put("DESL011", new Location(49.237227,7.036322));
        locationDictionary.put("DESL020", new Location(49.230740,7.003174));
        locationDictionary.put("DESL013", new Location(49.322646,6.753639));
        locationDictionary.put("DEUB004", new Location(47.913258,7.908036));
        locationDictionary.put("DESN080", new Location(51.396095,12.234053));
        locationDictionary.put("DESH006", new Location(54.527298,9.549637));
        locationDictionary.put("DEUB029", new Location(50.654066,10.769533));
        locationDictionary.put("DEBY067", new Location(49.321955,12.128139));
        locationDictionary.put("DESN074", new Location(50.659097,13.465077));
        locationDictionary.put("DENW179", new Location(51.448761,7.582294));
        locationDictionary.put("DENW064", new Location(50.653236,6.281070));
        locationDictionary.put("DENW068", new Location(51.570660,8.148061));
        locationDictionary.put("DENW206", new Location(51.176151,7.084070));
        locationDictionary.put("DENW080", new Location(51.183773,7.052633));
        locationDictionary.put("DEHE026", new Location(50.164430,9.399442));
        locationDictionary.put("DESH014", new Location(54.327816,8.603364));
        locationDictionary.put("DENW245", new Location(50.764801,6.232622));
        locationDictionary.put("DEBW118", new Location(48.788250,9.191389));
        locationDictionary.put("DEBW116", new Location(48.768658,9.184538));
        locationDictionary.put("DEBW099", new Location(48.783798,9.179286));
        locationDictionary.put("DETH072", new Location(50.611530,10.693091));
        locationDictionary.put("DESL018", new Location(49.299370,7.061678));
        locationDictionary.put("DERP020", new Location(49.754192,6.646761));
        locationDictionary.put("DERP047", new Location(49.783939,6.690489));
        locationDictionary.put("DEBW136", new Location(48.520319,9.057975));
        locationDictionary.put("DEBW137", new Location(48.526382,8.979433));
        locationDictionary.put("DENW010", new Location(51.547493,7.693836));
        locationDictionary.put("DEST098", new Location(51.662452,11.043383));
        locationDictionary.put("DEBY026", new Location(48.769024,11.616809));
        locationDictionary.put("DESL017", new Location(49.254344,6.867744));
        locationDictionary.put("DEUB005", new Location(52.800770,10.756733));
        locationDictionary.put("DENW181", new Location(51.443012,8.360714));
        locationDictionary.put("DEBY075", new Location(49.678951,12.159361));
        locationDictionary.put("DEBW023", new Location(47.588152,7.633272));
        locationDictionary.put("DETH083", new Location(50.977463,11.326070));
        locationDictionary.put("DEST011", new Location(51.839360,10.790175));
        locationDictionary.put("DERP015", new Location(50.266319,6.380622));
        locationDictionary.put("DEUB001", new Location(54.924969,8.308208));
        locationDictionary.put("DERP016", new Location(50.766750,7.972717));
        locationDictionary.put("DERP028", new Location(50.424568,7.732456));
        locationDictionary.put("DERP013", new Location(49.423138,7.293522));
        locationDictionary.put("DEST066", new Location(51.870852,12.663689));
        locationDictionary.put("DEST092", new Location(51.867462,12.598325));
        locationDictionary.put("DERP023", new Location(49.629524,8.355330));
        locationDictionary.put("DENW189", new Location(51.260681,7.147400));
        locationDictionary.put("DENW114", new Location(51.277647,7.231894));
        locationDictionary.put("DERP025", new Location(49.052321,8.253548));
        locationDictionary.put("DEST089", new Location(52.593169,11.172350));
        locationDictionary.put("DEST028", new Location(51.054580,12.141314));
        locationDictionary.put("DETH060", new Location(50.653248,10.668641));
        locationDictionary.put("DEUB028", new Location(54.436985,12.721938));
        locationDictionary.put("DESN052", new Location(50.731480,13.751450));
        locationDictionary.put("DESN045", new Location(50.892377,14.822846));
        locationDictionary.put("DESN091", new Location(50.720405,12.486623));
        locationDictionary.put("DEBW219", new Location(48.946250,9.440912));
        locationDictionary.put("DESN093", new Location(50.963223,12.212343));
        locationDictionary.put("DEBY124", new Location(49.444476,10.324420));
        locationDictionary.put("DESN104", new Location(50.847620,12.946543));
        locationDictionary.put("DEBB087", new Location(51.753880,14.321745));
        locationDictionary.put("DEHE095", new Location(50.576093,8.492643));
        locationDictionary.put("DENW338", new Location(51.487870,6.730838));
        locationDictionary.put("DESH056", new Location(54.616667,9.366667));
        locationDictionary.put("DETH117", new Location(50.999901,11.055927));
        locationDictionary.put("DEBW220", new Location(48.741255,9.314236));
        locationDictionary.put("DEBB092", new Location(52.347224,14.550567));
        locationDictionary.put("DEBW226", new Location(47.656566,9.470080));
        locationDictionary.put("DEHE134", new Location(50.553896,9.646366));
        locationDictionary.put("DEBY196", new Location(47.501710,11.097880));
        locationDictionary.put("DEMV026", new Location(54.293590,13.379766));
        locationDictionary.put("DENW351", new Location(51.524026,7.060463));
        locationDictionary.put("DENW367", new Location(51.570475,6.991670));
        locationDictionary.put("DEST106", new Location(51.464780,11.065590));
        locationDictionary.put("DEHH079", new Location(53.547460,9.912260));
        locationDictionary.put("DEHH081", new Location(53.544410,9.994080));
        locationDictionary.put("DEBB099", new Location(52.481497,13.854112));
        locationDictionary.put("DENW329", new Location(51.034979,6.450964));
        locationDictionary.put("DENW337", new Location(51.102020,6.459109));
        locationDictionary.put("DENW307", new Location(51.481914,6.525116));
        locationDictionary.put("DESH057", new Location(54.350647,10.108806));
        locationDictionary.put("DESH052", new Location(54.303826,10.124113));
        locationDictionary.put("DEBW221", new Location(47.669406,9.181659));
        locationDictionary.put("DEBW222", new Location(48.637417,9.797469));
        locationDictionary.put("DEBW223", new Location(48.690543,9.167316));
        locationDictionary.put("DENW355", new Location(51.033998,7.023054));
        locationDictionary.put("DEHE131", new Location(50.388433,8.059359));
        locationDictionary.put("DESH055", new Location(53.871876,10.667610));
        locationDictionary.put("DESH053", new Location(53.853746,10.663205));
        locationDictionary.put("DEST112", new Location(52.128070,11.630269));
        locationDictionary.put("DENW359", new Location(51.093665,6.396545));
        locationDictionary.put("DENW301", new Location(51.430854,6.846292));
        locationDictionary.put("DEBY189", new Location(48.190516,11.471632));
        locationDictionary.put("DEBY187", new Location(48.954334,10.599228));
        locationDictionary.put("DEHE116", new Location(50.102291,8.784467));
        locationDictionary.put("DENI143", new Location(53.142526,8.210731));
        locationDictionary.put("DERP060", new Location(49.197883,7.605288));
        locationDictionary.put("DENW374", new Location(51.579012,7.180172));
        locationDictionary.put("DEMV031", new Location(54.177035,12.113288));
        locationDictionary.put("DEBW156", new Location(48.230405,8.394592));
        locationDictionary.put("DEBY188", new Location(49.323654,11.030950));
        locationDictionary.put("DERP053", new Location(49.346340,8.420940));
        locationDictionary.put("DEST105", new Location(52.597809,11.848227));
        locationDictionary.put("DEMV025", new Location(54.320893,13.079745));
        locationDictionary.put("DEST108", new Location(51.196061,11.961086));
        locationDictionary.put("DEHE112", new Location(50.069536,8.225895));
        locationDictionary.put("DEMV028", new Location(53.897942,11.451602));
        locationDictionary.put("DENW375", new Location(51.439540,7.344050));
        locationDictionary.put("DENI157", new Location(52.427881,10.793056));
        locationDictionary.put("DEMV027", new Location(54.053041,13.777714));
        locationDictionary.put("DEST039", new Location(51.799423, 10.615218));

        locationNamesToCoordinates = Collections.unmodifiableMap(locationDictionary);
    }
}