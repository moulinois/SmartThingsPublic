/*
 *  Weather Forecast
 *
 *  Author: MSEGS
 *  V2.0
 *  Date: 2019-03-24, 2021-01-30
 */
metadata {
    definition (name: "Weather Forecast", namespace: "mysmartthingsapp", author: "MSEGS") {
	capability "Temperature Measurement"
	capability "Illuminance Measurement"
	capability "Relative Humidity Measurement"
	capability "Ultraviolet Index"
	capability "Refresh"

	attribute "lastUpdate", "string"        
	attribute "localSunrise", "string"
	attribute "localSunset", "string"
	attribute "city", "string"
	attribute "weather", "string"
	attribute "illuminance", "string"
	attribute "ultravioletIndex", "string"
	attribute "uvDescription", "string"
    	attribute "cloudCover", "string"
	attribute "wind", "string"
	attribute "windVector", "string"
	attribute "visibility", "string"    
	attribute "moonPhase", "string"
    	attribute "weatherIcon", "string"
	attribute "feelsLike", "string"
	attribute "percentPrecip", "string"
	attribute "rain", "string"    
	attribute "precipType", "string"
    	attribute "qpf", "string"    
    	attribute "precipType+QPF", "string"    
	attribute "snowRange", "string"
    	attribute "alert", "string"
	attribute "todaySummary", "string"
	attribute "tomorrowSummary", "string"
	attribute "seconddaySummary", "string"
	attribute "thirddaySummary", "string"
	attribute "todayShort", "string"
	attribute "todayLong", "string"
	attribute "tomorrowShort", "string"
	attribute "tomorrowLong", "string"
	attribute "day2Short", "string"
	attribute "day2Long", "string"
	attribute "day3Short", "string"
	attribute "day3Long", "string"
	attribute "todayHigh", "string"
	attribute "todayLow", "string"
	attribute "tomorrowHigh", "string"
	attribute "tomorrowLow", "string"
	attribute "seconddayHigh", "string"
	attribute "seconddayLow", "string"
	attribute "thirddayHigh", "string"
	attribute "thirddayLow", "string"
	attribute "todayPH", "string"
	attribute "tomorrowPH", "string"
	attribute "day2PH", "string"
	attribute "day3PH", "string"
    }

    preferences {
        input "zipCode", "text", title: "Zip Code (optional)", required: false
    	input "frequency", "number", title: "Update this many minutes:", description: "Minutes", required: false, defaultValue: 15
    	input "showMeasure", "bool", title: "Show measure units", description: "C/F, KPH/MPH ...", required: false
    	input "showDegreeSymbol", "bool", title: "Show degree symbol", description: "Â°", required: false
    }
}

def icons(){
	state "0", icon:"https://smartthings-twc-icons.s3.amazonaws.com/00.png", label: ""
	state "1", icon:"https://smartthings-twc-icons.s3.amazonaws.com/01.png", label: ""
	state "2", icon:"https://smartthings-twc-icons.s3.amazonaws.com/02.png", label: ""
	state "3", icon:"https://smartthings-twc-icons.s3.amazonaws.com/03.png", label: ""
	state "4", icon:"https://smartthings-twc-icons.s3.amazonaws.com/04.png", label: ""
	state "5", icon:"https://smartthings-twc-icons.s3.amazonaws.com/05.png", label: ""
	state "6", icon:"https://smartthings-twc-icons.s3.amazonaws.com/06.png", label: ""
	state "7", icon:"https://smartthings-twc-icons.s3.amazonaws.com/07.png", label: ""
	state "8", icon:"https://smartthings-twc-icons.s3.amazonaws.com/08.png", label: ""
	state "9", icon:"https://smartthings-twc-icons.s3.amazonaws.com/09.png", label: ""
	state "10", icon:"https://smartthings-twc-icons.s3.amazonaws.com/10.png", label: ""
	state "11", icon:"https://smartthings-twc-icons.s3.amazonaws.com/11.png", label: ""
	state "12", icon:"https://smartthings-twc-icons.s3.amazonaws.com/12.png", label: ""
	state "13", icon:"https://smartthings-twc-icons.s3.amazonaws.com/13.png", label: ""
	state "14", icon:"https://smartthings-twc-icons.s3.amazonaws.com/14.png", label: ""
	state "15", icon:"https://smartthings-twc-icons.s3.amazonaws.com/15.png", label: ""
	state "16", icon:"https://smartthings-twc-icons.s3.amazonaws.com/16.png", label: ""
	state "17", icon:"https://smartthings-twc-icons.s3.amazonaws.com/17.png", label: ""
	state "18", icon:"https://smartthings-twc-icons.s3.amazonaws.com/18.png", label: ""
	state "19", icon:"https://smartthings-twc-icons.s3.amazonaws.com/19.png", label: ""
	state "20", icon:"https://smartthings-twc-icons.s3.amazonaws.com/20.png", label: ""
	state "21", icon:"https://smartthings-twc-icons.s3.amazonaws.com/21.png", label: ""
	state "22", icon:"https://smartthings-twc-icons.s3.amazonaws.com/22.png", label: ""
	state "23", icon:"https://smartthings-twc-icons.s3.amazonaws.com/23.png", label: ""
	state "24", icon:"https://smartthings-twc-icons.s3.amazonaws.com/24.png", label: ""
	state "25", icon:"https://smartthings-twc-icons.s3.amazonaws.com/25.png", label: ""
	state "26", icon:"https://smartthings-twc-icons.s3.amazonaws.com/26.png", label: ""
	state "27", icon:"https://smartthings-twc-icons.s3.amazonaws.com/27.png", label: ""
	state "28", icon:"https://smartthings-twc-icons.s3.amazonaws.com/28.png", label: ""
	state "29", icon:"https://smartthings-twc-icons.s3.amazonaws.com/29.png", label: ""
	state "30", icon:"https://smartthings-twc-icons.s3.amazonaws.com/30.png", label: ""
	state "31", icon:"https://smartthings-twc-icons.s3.amazonaws.com/31.png", label: ""
	state "32", icon:"https://smartthings-twc-icons.s3.amazonaws.com/32.png", label: ""
	state "33", icon:"https://smartthings-twc-icons.s3.amazonaws.com/33.png", label: ""
	state "34", icon:"https://smartthings-twc-icons.s3.amazonaws.com/34.png", label: ""
	state "35", icon:"https://smartthings-twc-icons.s3.amazonaws.com/35.png", label: ""
	state "36", icon:"https://smartthings-twc-icons.s3.amazonaws.com/36.png", label: ""
	state "37", icon:"https://smartthings-twc-icons.s3.amazonaws.com/37.png", label: ""
	state "38", icon:"https://smartthings-twc-icons.s3.amazonaws.com/38.png", label: ""
	state "39", icon:"https://smartthings-twc-icons.s3.amazonaws.com/39.png", label: ""
	state "40", icon:"https://smartthings-twc-icons.s3.amazonaws.com/40.png", label: ""
	state "41", icon:"https://smartthings-twc-icons.s3.amazonaws.com/41.png", label: ""
	state "42", icon:"https://smartthings-twc-icons.s3.amazonaws.com/42.png", label: ""
	state "43", icon:"https://smartthings-twc-icons.s3.amazonaws.com/43.png", label: ""
	state "44", icon:"https://smartthings-twc-icons.s3.amazonaws.com/44.png", label: ""
	state "45", icon:"https://smartthings-twc-icons.s3.amazonaws.com/45.png", label: ""
	state "46", icon:"https://smartthings-twc-icons.s3.amazonaws.com/46.png", label: ""
	state "47", icon:"https://smartthings-twc-icons.s3.amazonaws.com/47.png", label: ""
	state "na", icon:"https://smartthings-twc-icons.s3.amazonaws.com/na.png", label: ""
}

def parse(String description) {
    log.debug "Parsing '${description}'"
}

def installed() {
    poll()
    initialize()
}

def uninstalled() {
    unschedule()
}

def updated(){
    log.debug "updated()"
    initialize()
}

def initialize(){
	if(frequency){
		schedule("0 0/$frequency * ? * * *", poll)
	}else{
		runEvery15Minutes(poll)
	}
}

def poll() {
    log.info "WSTATION: Executing 'poll', location: ${location.name}"

    def timeZone = location.timeZone ?: timeZone(timeOfDay)
    def timeStamp = new Date().format("MMM dd EEE h:mm a", location.timeZone)
    sendEvent(name: "lastUpdate", value: timeStamp, displayed: false)

    def tempSymbol, tempScale, windUnits, distanceUnits, qpfUnits, percentSymbol
    if (showMeasure){
    	tempScale = getTemperatureScale()
    	windUnits = tempScale == "C" ? "KPH" : "MPH"
    	distanceUnits = tempScale == "C" ? "K" : "M"
    	qpfUnits = tempScale == "C" ? "CM" : "IN"
        percentSymbol = "%"
		if(showDegreeSymbol){tempSymbol = "Â° "}else{tempSymbol = ""}
    }else{
    	tempScale = ""
        windUnits = ""
    	distanceUnits = ""
    	qpfUnits = ""
        percentSymbol = ""
		if(showDegreeSymbol){tempSymbol = "Â° "}else{tempSymbol = ""}
	}    
    
    def obs = getTwcConditions(zipCode)
    if (obs) {
        def windVector = "${obs.windDirectionCardinal} ${obs.windSpeed}"
        send(name: "weatherIcon", value: obs.iconCode as String, displayed: false)
        send(name: "temperature", value: obs.temperature, unit: tempSymbol+tempScale, displayed: true)
        send(name: "feelsLike", value: obs.temperatureFeelsLike, unit: tempSymbol+tempScale, displayed: false)
        send(name: "humidity", value: obs.relativeHumidity, unit: percentSymbol, displayed: false)
        send(name: "weather", value: obs.wxPhraseLong, displayed: false)
        send(name: "wind", value: obs.windSpeed as String, unit: windUnits, displayed: false)
        send(name: "windVector", value: windVector, unit: windUnits, displayed: false)
        send(name: "visibility", value: obs.visibility, unit: distanceUnits, displayed: false)

		def weatherCondition = obs.wxPhraseLong
        def filterList = ["rain", "thunder"]
		def isRaining = false
		filterList.each() { word ->
        if(weatherCondition.toLowerCase().contains(word)) {isRaining = true}
		}
		send(name: "rain", value: isRaining, displayed: false)

		log.trace "Getting location info"
        def loc = getTwcLocation(zipCode).location
        def cityValue = "${loc.city}, ${loc.adminDistrictCode} ${loc.countryCode}"
        if (cityValue != device.currentValue("city")) {
            send(name: "city", value: cityValue, isStateChange: true, displayed: false)
        }
        
        send(name: "ultravioletIndex", value: obs.uvIndex, displayed: false)
        send(name: "uvDescription", value: obs.uvDescription, displayed: false)

        def dtf = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")

        def sunriseDate = dtf.parse(obs.sunriseTimeLocal)
        log.info "'${obs.sunriseTimeLocal}'"

        def sunsetDate = dtf.parse(obs.sunsetTimeLocal)

        def tf = new java.text.SimpleDateFormat("h:mm a")
        tf.setTimeZone(TimeZone.getTimeZone(loc.ianaTimeZone))

        def localSunrise = "${tf.format(sunriseDate)}"
        def localSunset = "${tf.format(sunsetDate)}"
        send(name: "localSunrise", value: localSunrise, descriptionText: "Sunrise today is at $localSunrise")
        send(name: "localSunset", value: localSunset, descriptionText: "Sunset today at is $localSunset")

        send(name: "illuminance", value: estimateLux(obs, sunriseDate, sunsetDate), displayed: false)

        // Forecast
        def f = getTwcForecast(zipCode)
        if (f) {
            def icon, cloudCover, precipType, precipType_QPF, precipChance, snowRange, narrative, forecastTodayShort, forecastTodayLong, todayPH
            icon = f.daypart[0].iconCode[0] ?: f.daypart[0].iconCode[1]
			precipChance = f.daypart[0].precipChance[0] ?: f.daypart[0].precipChance[1]
            
            def precipTypeToday = "${f.daypart[0].precipType[0]}"
            precipTypeToday = precipTypeToday.replace("precip","N/A")
            def precipDescToday = precipTypeToday[0].toUpperCase() + precipTypeToday.substring(1)
            def precipTypeTonight = "${f.daypart[0].precipType[1]}"
            precipTypeTonight = precipTypeTonight.replace("precip","N/A")
            def precipDescTonight = precipTypeTonight[0].toUpperCase() + precipTypeTonight.substring(1)
            
            def precipTypeTom = "${f.daypart[0].precipType[2]}"
            precipTypeTom = precipTypeTom.replace("precip","N/A")
            def precipDescTom = precipTypeTom[0].toUpperCase() + precipTypeTom.substring(1)
            
            def precipTypeDay2 = "${f.daypart[0].precipType[4]}"
            precipTypeDay2 = precipTypeDay2.replace("precip","N/A")
            def precipDescDay2 = precipTypeDay2[0].toUpperCase() + precipTypeDay2.substring(1)
            
            def precipTypeDay3 = "${f.daypart[0].precipType[6]}"
            precipTypeDay3 = precipTypeDay3.replace("precip","N/A")
            def precipDescDay3 = precipTypeDay3[0].toUpperCase() + precipTypeDay3.substring(1)
            
            if(timeOfDayIsBetween("05:00", "15:00", new Date(), location.timeZone)){
            narrative = "Today\n${f.daypart[0].narrative[0]}\n"
            cloudCover = "${f.daypart[0].cloudCover[0]}"
            forecastTodayShort = "TODAY\n${f.daypart[0].wxPhraseShort[0]}\n\n${f.temperatureMax[0]}   |   ${f.temperatureMin[0]}"
            forecastTodayLong = "TODAY:\n\n ${f.daypart[0].wxPhraseLong[0]}\n\n High: ${f.temperatureMax[0]} Low: ${f.temperatureMin[0]}\n Humid: ${f.daypart[0].relativeHumidity[0]}%\n Percip: ${f.daypart[0].precipChance[0]}%"
            todayPH = "Humidity: ${f.daypart[0].relativeHumidity[0]}%, Precip: ${f.daypart[0].precipChance[0]}% - ${precipDescToday}"
            precipType = "${precipDescToday}"
            precipType_QPF = "${precipDescToday} - ${qpf(f)}"
            snowRange = "${f.daypart[0].snowRange[0]}"
            }else{
            narrative = "Tonight\n${f.daypart[0].narrative[1]}\n"
            cloudCover = "${f.daypart[0].cloudCover[1]}"
            forecastTodayShort = "TONIGHT\n${f.daypart[0].wxPhraseShort[1]}\n\nLow: ${f.temperatureMin[0]}"
            forecastTodayLong = "TONIGHT:\n\n ${f.daypart[0].wxPhraseLong[1]}\n\n Low: ${f.temperatureMin[0]}\n Humid: ${f.daypart[0].relativeHumidity[1]}%\n Percip: ${f.daypart[0].precipChance[1]}%"
            todayPH = "Humidity: ${f.daypart[0].relativeHumidity[1]}%, Precip: ${f.daypart[0].precipChance[1]}% - ${precipDescTonight}"
            precipType = "${precipDescTonight}"
            precipType_QPF = "${precipDescTonight} - ${qpf(f)}"
            snowRange = "${f.daypart[0].snowRange[1]}"
            }
            def tomorrowForecast = "${f.dayOfWeek[1]}\n${f.narrative[1]}"
            def seconddayForecast = "${f.dayOfWeek[2]}\n${f.narrative[2]}"
            def thirddayForecast = "${f.dayOfWeek[3]}\n${f.narrative[3]}"
            def todayHigh = f.temperatureMax[0]
            def todayLow = f.temperatureMin[0]
            def tomorrowHigh = f.temperatureMax[1]
            def tomorrowLow = f.temperatureMin[1]
            def seconddayHigh = f.temperatureMax[2]
            def seconddayLow = f.temperatureMin[2]
            def thirddayHigh = f.temperatureMax[3]
            def thirddayLow = f.temperatureMin[3]
            def tomorrowPH = "Humidity: ${f.daypart[0].relativeHumidity[2]}%, Precip: ${f.daypart[0].precipChance[2]}% - ${precipDescTom}"
            def seconddayPH = "Humidity: ${f.daypart[0].relativeHumidity[2]}%, Precip: ${f.daypart[0].precipChance[4]}% - ${precipDescDay2}"
            def thirddayPH = "Humidity: ${f.daypart[0].relativeHumidity[2]}%, Precip: ${f.daypart[0].precipChance[6]}% - ${precipDescDay3}"
            def forecastTomShort = "${f.dayOfWeek[1].toUpperCase().substring(0, 3)}\n${f.daypart[0].wxPhraseShort[2]}\n\n${f.temperatureMax[1]}   |   ${f.temperatureMin[1]}"
            def forecastTomLong = "${f.dayOfWeek[1].toUpperCase()}:\n\n ${f.daypart[0].wxPhraseLong[2]}\n\n High: ${f.temperatureMax[1]} Low: ${f.temperatureMin[1]}\n Humid: ${f.daypart[0].relativeHumidity[2]}%\n Percip: ${f.daypart[0].precipChance[2]}%"
            def forecastDay2Short = "${f.dayOfWeek[2].toUpperCase().substring(0, 3)}\n${f.daypart[0].wxPhraseShort[4]}\n\n${f.temperatureMax[2]}   |   ${f.temperatureMin[2]}"
            def forecastDay2Long = "${f.dayOfWeek[2].toUpperCase()}:\n\n ${f.daypart[0].wxPhraseLong[4]}\n\n High: ${f.temperatureMax[2]} Low: ${f.temperatureMin[2]}\n Humid: ${f.daypart[0].relativeHumidity[4]}%\n Percip: ${f.daypart[0].precipChance[4]}%"
            def forecastDay3Short = "${f.dayOfWeek[3].toUpperCase().substring(0, 3)}\n${f.daypart[0].wxPhraseShort[6]}\n\n${f.temperatureMax[3]}   |   ${f.temperatureMin[3]}"
            def forecastDay3Long = "${f.dayOfWeek[3].toUpperCase()}:\n\n ${f.daypart[0].wxPhraseLong[6]}\n\n High: ${f.temperatureMax[3]} Low: ${f.temperatureMin[3]}\n Humid: ${f.daypart[0].relativeHumidity[6]}%\n Percip: ${f.daypart[0].precipChance[6]}%"
			send(name: "cloudCover", value: cloudCover, unit: percentSymbol, displayed: false)
			send(name: "percentPrecip", value: precipChance, unit: percentSymbol, displayed: false)
			send(name: "precipType", value: precipType, displayed: false)
                        send(name: "qpf", value: qpf(f), unit: qpfUnits, displayed: false)
			send(name: "precipType+QPF", value: precipType_QPF, unit: qpfUnits, displayed: false)
                        send(name: "snowRange", value: snowRange, unit: qpfUnits, displayed: false)
                        send(name: "moonPhase", value: f.moonPhase[0], displayed: false)
			send(name: "todaySummary", value: narrative)
			send(name: "tomorrowSummary", value: tomorrowForecast, displayed: false)
			send(name: "seconddaySummary", value: seconddayForecast, displayed: false)
			send(name: "thirddaySummary", value: thirddayForecast, displayed: false)
			send(name: "todayShort", value: forecastTodayShort, displayed: false)
			send(name: "todayLong", value: forecastTodayLong, displayed: false)
			send(name: "tomorrowShort", value: forecastTomShort, displayed: false)
			send(name: "tomorrowLong", value: forecastTomLong, displayed: false)
			send(name: "day2Short", value: forecastDay2Short, displayed: false)
			send(name: "day2Long", value: forecastDay2Long, displayed: false)
			send(name: "day3Short", value: forecastDay3Short, displayed: false)
			send(name: "day3Long", value: forecastDay3Long, displayed: false)
			send(name: "todayHigh", value: todayHigh, displayed: false)
			send(name: "tomorrowHigh", value: tomorrowHigh, unit: tempSymbol+tempScale, displayed: false)
			send(name: "seconddayHigh", value: seconddayHigh, unit: tempSymbol+tempScale, displayed: false)
			send(name: "thirddayHigh", value: thirddayHigh, unit: tempSymbol+tempScale, displayed: false)
			send(name: "todayLow", value: todayLow, displayed: false)
			send(name: "tomorrowLow", value: tomorrowLow, unit: tempSymbol+tempScale, displayed: false)
			send(name: "seconddayLow", value: seconddayLow, unit: tempSymbol+tempScale, displayed: false)
			send(name: "thirddayLow", value: thirddayLow, unit: tempSymbol+tempScale, displayed: false)
			send(name: "todayPH", value: todayPH, displayed: false)
			send(name: "tomorrowPH", value: tomorrowPH, displayed: false)
			send(name: "day2PH", value: seconddayPH, displayed: false)
			send(name: "day3PH", value: thirddayPH, displayed: false)
        }
        else {
            log.warn "Forecast not found"
        }

        // Alerts
        def alerts = getTwcAlerts("${loc.latitude},${loc.longitude}")
        if (alerts) {
            alerts.each {alert ->
                def msg = alert.headlineText
                if (alert.effectiveTimeLocal && !msg.contains(" from ")) {
                    msg += " from ${parseAlertTime(alert.effectiveTimeLocal).format("E hh:mm a", TimeZone.getTimeZone(alert.effectiveTimeLocalTimeZone))}"
                }
                if (alert.expireTimeLocal && !msg.contains(" until ")) {
                    msg += " until ${parseAlertTime(alert.expireTimeLocal).format("E hh:mm a", TimeZone.getTimeZone(alert.expireTimeLocalTimeZone))}"
                }
                send(name: "alert", value: msg, descriptionText: msg)
            }
        }
        else {
            send(name: "alert", value: "No current alerts", descriptionText: msg)
        }
    }
    else {
        log.warn "No response from TWC API"
    }
    
    return null
}

def parseAlertTime(s) {
    def dtf = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
    def s2 = s.replaceAll(/([0-9][0-9]):([0-9][0-9])$/,'$1$2')
    dtf.parse(s2)
}

def refresh() {
    poll()
}

def configure() {
    poll()
}

private pad(String s, size = 25) {
    def n = (size - s.size()) / 2
    if (n > 0) {
        def sb = ""
        n.times {sb += " "}
        sb += s
        n.times {sb += " "}
        return sb
    }
    else {
        return s
    }
}

private localDate(timeZone) {
    def df = new java.text.SimpleDateFormat("yyyy-MM-dd")
    df.setTimeZone(TimeZone.getTimeZone(timeZone))
    df.format(new Date())
}

private send(map) {
    log.debug "WSTATION: event: $map"
    sendEvent(map)
}

private estimateLux(obs, sunriseDate, sunsetDate) {
    def lux = 0
    if (obs.dayOrNight == 'N') {
        lux = 10
    }
    else {
        //day
        switch(obs.iconCode) {
            case '04':
                lux = 200
                break
            case ['05', '06', '07', '08', '09', '10',
                  '11', '12', '13','14', '15','17','18','19','20',
                  '21','22','23','24','25','26']:
                lux = 1000
                break
            case ['27', '28']:
                lux = 2500
                break
            case ['29', '30']:
                lux = 7500
                break
            default:
                //sunny, clear
                lux = 10000
        }

        //adjust for dusk/dawn
        def now = new Date().time
        def afterSunrise = now - sunriseDate.time
        def beforeSunset = sunsetDate.time - now
        def oneHour = 1000 * 60 * 60

        if(afterSunrise < oneHour) {
            //dawn
            lux = (long)(lux * (afterSunrise/oneHour))
        } else if (beforeSunset < oneHour) {
            //dusk
            lux = (long)(lux * (beforeSunset/oneHour))
        }
    }
    lux
}

private qpf(f){
def qpAmt = 0	
    if(timeOfDayIsBetween("05:00", "15:00", new Date(), location.timeZone)){
		if(f.daypart[0].precipType[0] == "snow"){
			qpAmt = f.daypart[0].qpfSnow[0]
        }else{
        	qpAmt = f.daypart[0].qpf[0]
		}
    }else{
		if(f.daypart[0].precipType[1] == "snow"){
			qpAmt = f.daypart[0].qpfSnow[1]
		}else{
        	qpAmt = f.daypart[0].qpf[1]
		}
    }
    qpAmt
}