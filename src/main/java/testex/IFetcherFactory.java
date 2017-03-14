/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex;

import java.util.List;

/**
 *
 * @author Kim
 */
interface IFetcherFactory {
  String[] getAvailableTypes();
  List<IJokeFetcher> getJokeFetchers(String jokesToFetch);
}
