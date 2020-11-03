package org.vector.littlejourney.entity;

import org.vector.littlejourney.exception.InvalidObjectBuildException;
import org.vector.littlejourney.exception.InvalidPrimitiveValueException;
import org.vector.littlejourney.exception.Reason;
import org.vector.littlejourney.util.DateUtils;

import java.util.Date;

public class Trip {

    private Route route;

    private double cost;

    private Date duration;

    public Trip(Route route, double cost, Date duration) {

        if (route == null || duration == null) {

            throw new InvalidObjectBuildException(Reason.NULL_REFERENCE.getReason());

        } else if (cost < 0) {

            throw new InvalidPrimitiveValueException(Reason.LESS_THAN_ZERO_NUMBER_INPUT.getReason());

        } else {

            this.route = route;

            this.cost = cost;

            this.duration = duration;
        }
    }

    public Route getRoute() {

        return route;
    }

    public void setRoute(Route route) {

        if (route == null) {

            throw new InvalidObjectBuildException(Reason.NULL_REFERENCE.getReason());

        } else {

            this.route = route;
        }
    }

    public double getCost() {

        return cost;
    }

    public void setCost(double cost) {

        if (cost < 0) {

            throw new InvalidPrimitiveValueException(Reason.LESS_THAN_ZERO_NUMBER_INPUT.getReason());

        } else {

            this.cost = cost;
        }
    }

    public Date getDuration() {

        return duration;
    }

    public void setDuration(Date duration) {

        if (duration == null) {

            throw new InvalidObjectBuildException(Reason.NULL_REFERENCE.getReason());

        } else {

            this.duration = duration;
        }
    }

    @Override
    public String toString() {

        return "Станция отправления - " + route.getDeparture().toString().toUpperCase() + "; " +

                "станция прибытия - " + route.getArrival().toString().toUpperCase() + "; " +

                "цена: " + String.format("%.2f", cost) + "; " + "длительность маршрута: " +

                DateUtils.toSimpleFormat(duration, "hh:mm");
    }
}
