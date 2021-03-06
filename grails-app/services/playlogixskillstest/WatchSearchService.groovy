package playlogixskillstest

import grails.transaction.Transactional

class WatchSearchService {

    /**
     * Builds up a search criteria for the Watch table and returns a list of relevant matches
     * @param brand - The brand name
     * @param price - The price to search for
     * @param warranty - The warranty duration to find
     * @return A list of products matching the query
     */
    def search(List<String> brands, double price, int warranty) {
        def c = Watch.createCriteria()

        List<Watch> products = new ArrayList<Watch>()

        products = c.listDistinct {

            if(brands){
                or {
                    brands.each {
                        ilike('brand', '%'+it+'%')
                    }
                }
            }

            if(price > 0){
                and {
                    between('price', 0 as Double, price)
                }
            }

            if(warranty > 0){
                and{
                    between('warranty', 0, warranty)
                }
            }
        }

        return products
    }
}
