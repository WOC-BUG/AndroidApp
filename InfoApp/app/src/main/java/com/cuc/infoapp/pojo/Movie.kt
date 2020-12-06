package com.cuc.infoapp.pojo

class Movie(error_code :Int,reason :String,movieid :String,actors :String,also_known_as:String,country:String,directors:String,
            film_locations:String, generes:String,language:String,plot_simple:String,poster:String,rated:String,rating :String,
            rating_count:String,release_date:String,runtime:String,title:String,type:String,writers:String,year:Int) {
    private var error_code :Int?=null
    private var reason :String?=null
    //result集还没定义
    private var movieid :String?=null
    private var actors :String?=null
    private var also_known_as:String?=null
    private var country:String?=null
    private var directors:String?=null
    private var film_locations:String?=null
    private var generes:String?=null
    private var language:String?=null
    private var plot_simple:String?=null
    private var poster:String?=null
    private var rated:String?=null
    private var rating :String?=null
    private var rating_count:String?=null
    private var release_date:String?=null
    private var runtime:String?=null
    private var title:String?=null
    private var type:String?=null
    private var writers:String?=null
    private var year:Int?=null

    init {
        this.error_code=error_code
        this.reason=reason
        this.movieid=movieid
        this.actors=actors
        this.also_known_as=also_known_as
        this.country=country
        this.directors=directors
        this.film_locations=film_locations
        this.generes=generes
        this.language=language
        this.plot_simple=plot_simple
        this.poster=poster
        this.rated=rated
        this.rating=rating
        this.rating_count=rating_count
        this.release_date=release_date
        this.runtime=runtime
        this.title=title
        this.type=type
        this.writers=writers
        this.year=year
    }
    fun getError_code(): Int? {
        return error_code
    }
    fun setError_code(error_code: Int) {
        this.error_code = error_code
    }
    fun getReason():String?{
        return reason
    }
    fun setReason(reason: String) {
        this.reason =reason
    }
    fun getMovieid():String?{
        return movieid
    }
    fun setMovieid(movieid: String){
        this.movieid=movieid
    }
    fun getAlsoknownas(): String? {
        return also_known_as
    }
    fun setAlsoknownas(Alsoknownas: String){
        this.also_known_as=also_known_as}

    fun getActors(): String? {
        return actors
    }
    fun setactors(actors: String){
        this.actors=actors
    }

    fun getCountry(): String? {
        return country
    }
    fun setCountry(country: String){
        this.country=country
    }
    fun getDirectors(): String? {
        return directors
    }
    fun setDirectors(directors: String){
        this.directors=directors
    }
    fun getFilm_locations(): String? {
        return film_locations
    }
    fun setFilm_location(film_locations: String){
        this.film_locations=film_locations
    }
    fun getGenres(): String? {
        return generes
    }
    fun setGenres(generes: String){
        this.generes=generes
    }
    fun getLanguage(): String? {
        return language
    }
    fun setLanguage(language: String){
        this.language=language
    }
    fun getPlot_simple(): String? {
        return plot_simple
    }
    fun setPlot_simple(plot_simple: String){
        this.plot_simple=plot_simple
    }
    fun getPoster(): String? {
        return poster
    }
    fun setPoster(poster: String){
        this.poster
    }
    fun getRated(): String? {
        return rated
    }
    fun setRated(rated: String){
        this.rated
    }
    fun getRating(): String? {
        return rating
    }
    fun setRating(rated: String){
        this.rating
    }

    fun getRelease_date(): String? {
        return release_date
    }
    fun setRelease_date(release_date: String){
        this.release_date
    }
    fun getRuntime(): String? {
        return runtime
    }
    fun setRuntime(runtime: String){
        this.runtime
    }
    fun getTitle(): String? {
        return title}

    fun setTitle(title: String){
        this.title=title
    }
    fun getType(): String? {
        return type}

    fun setType(type: String){
        this.type=type
    }
    fun getWriters(): String? {
        return writers}

    fun setWriters(writers: String){
        this.writers=writers
    }
    fun getYear(): Int? {
        return year}

    fun setYear(year: Int){
        this.year=year
    }
}

