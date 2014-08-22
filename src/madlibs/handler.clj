(ns madlibs.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "<h1>Mad lib</h1>
							<p>Add your words:</p>
							<form action='/madlib-show'>
							First name:<input type='text' name='firstname' placeholder='first name'><br>
							Emotional state:<input type='text' name='emotionalstate' placeholder='emotionalstate'><br>
  						Colour: <input type='text' name='colour' placeholder='colour'><br>
  						Thing: <input type='text' name='thing' placeholder='thing'><br>
  						Bodypart: <input type='text' name='bodypart' placeholder='bodypart'><br>
  						Verb: <input type='text' name='verb' placeholder='verb'><br>
  						Location: <input type='text' name='place' placeholder='place'><br>
  						Object: <input type='text' name='object' placeholder='object'><br>
  						<input type='submit' value='Madlib me!'>
  						</form>")

  (GET "/madlib-show" [ firstname emotionalstate colour thing bodypart verb place object ] 
  	(str firstname " was seen looking rather " emotionalstate ". On " firstname "'s " bodypart " sat a " colour " " thing ". We all watched " firstname " " verb " all the way to " place " only to be promptly killed by a falling " object ".")
	)

  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
