package ru.job4j.srp;

import java.util.Objects;

    public class Employer {
        private String name;
        private long hired;
        private long fired;
        private double salary;

        public Employer(String name, long hired, long fired, double salary) {
            this.name = name;
            this.hired = hired;
            this.fired = fired;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getHired() {
            return hired;
        }

        public void setHired(long hired) {
            this.hired = hired;
        }

        public long getFired() {
            return fired;
        }

        public void setFired(long fired) {
            this.fired = fired;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Employer employer = (Employer) o;
            return Objects.equals(name, employer.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
